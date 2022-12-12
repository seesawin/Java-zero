package javaLanguage.oop.enmus;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;

public class TestExcel {
    public static void main(String[] args) throws IOException {
        InputStream is = TestExcel.class.getClassLoader().getResourceAsStream("customer.xlsx");
        final Workbook workbook = WorkbookFactory.create(is);
        final CustomerDTO dto = ExcelMappingEnum.parseExcel(workbook);
        System.out.println(dto.toString());
    }
}
