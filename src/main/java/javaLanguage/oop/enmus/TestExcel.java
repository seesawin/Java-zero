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

        System.out.println(ImplMethodEnum.ID.getValue());
        System.out.println(ImplMethodEnum.NAME.getValue());
        System.out.println(ImplMethodEnum.AGE.getValue());

        final NodeContainer nc = new NodeContainer();
        ImplMethodEnum.ID.setValue(nc, "id");
        System.out.println(nc.getValue());
        ImplMethodEnum.NAME.setValue(nc, "name");
        System.out.println(nc.getValue());
        ImplMethodEnum.AGE.setValue(nc, "age");
        System.out.println(nc.getValue());
    }
}
