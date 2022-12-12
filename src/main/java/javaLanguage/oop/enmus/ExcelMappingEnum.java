package javaLanguage.oop.enmus;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public enum ExcelMappingEnum {
    ID("A1", CustomerDTO::setId),
    NAME("A2", CustomerDTO::setName),
    AGE("A3", CustomerDTO::setAge);

    private String address;
    private Setter setter;
    private int rowIndex;
    private int columnIndex;

    public static final DataFormatter formatter = new DataFormatter(Locale.US);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    void assignValue(final CustomerDTO t, final String data) {
        setter.assignValue(t, data);
    }

    @FunctionalInterface
    interface Setter<T> {
        void assignValue(T t, String data);
    }

    ExcelMappingEnum(String address, Setter<CustomerDTO> setter) {
        final Pair<Integer, Integer> addressIndex = parseAddress(address);
        this.rowIndex = addressIndex.getLeft();
        this.columnIndex = addressIndex.getRight();
        this.address = address;
        this.setter = setter;
    }

    static Pair<Integer, Integer> parseAddress(final String address) {
        int loc = 0;
        final int length = address.length();
        for (; loc < length; loc++) {
            if (Character.isDigit(address.charAt(loc))) {
                break;
            }
        }
        final String sCol = address.substring(0, loc).toUpperCase();
        final String sRow = address.substring(loc);
        return Pair.of(Integer.parseInt(sRow) - 1, CellReference.convertColStringToIndex(sCol));
    }

    public static CustomerDTO parseExcel(final Workbook data) {
        final Sheet sheet = data.getSheet("Customer");
        final CustomerDTO dto = new CustomerDTO();
        for (ExcelMappingEnum e : values()) {
            e.assignValue(dto, getValue(e.rowIndex, e.columnIndex, sheet));
        }
        return dto;
    }

    static String getValue(final int rowIndex, final int columnIndex, final Sheet sheet) {
        if (sheet.getLastRowNum() < rowIndex) {
            throw new RuntimeException("ILLEGAL_EXCEL_ROW_ERROR");
        }
        final Row row = sheet.getRow(rowIndex);
        if (Objects.isNull(row)) {
            throw new RuntimeException("ILLEGAL_EXCEL_ROW_ERROR");
        }
        return getValue(columnIndex, row);
    }

    static String getValue(final int columnIndex, final Row row) {
        if (Objects.isNull(row) || isRowEmpty(row)) {
            return null;
        }
        if (row.getLastCellNum() < columnIndex) {
            throw new RuntimeException("ILLEGAL_EXCEL_COLUMN_ERROR");
        }
        return getValue(row.getCell(columnIndex));
    }

    static String getValue(final Cell cell) {
        if (Objects.isNull(cell)) {
            return null;
        }
        final CellType cellType = cell.getCellType();
        if (cellType == CellType._NONE) {
            return null;
        } else if (cellType == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
            return DATE_FORMATTER.format(cell.getLocalDateTimeCellValue());
        }
        final String value = formatter.formatCellValue(cell);
        return isBlank(value) ? value : value.trim();
    }

    static boolean isBlank(String value) {
        return value == null || "".equals(value) ? true : false;

    }

    static boolean isRowNotEmpty(final Row row) {
        return !isRowEmpty(row);
    }

    static boolean isRowEmpty(final Row row) {
        if (Objects.isNull(row)) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        if (row.getZeroHeight()) {
            //若欄位隱藏也當成是空的
            return true;
        }
        return isRowEmpty(row, row.getFirstCellNum(), row.getLastCellNum() - 1);
    }

    static boolean isRowEmpty(final Row row, int from, int to) {
        if (Objects.isNull(row)) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = from; cellNum <= to; cellNum++) {
            final Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

}

class CustomerDTO {
    private String id;
    private String name;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CustomerDTO, id: " + this.id + ", name: " + this.name + ", age: " + this.age;
    }
}
