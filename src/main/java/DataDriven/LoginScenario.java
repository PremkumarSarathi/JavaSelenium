package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginScenario {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static Object[][] testData(String excelPath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(excelPath);
        sheet = workbook.getSheet(sheetName);
        int i, j;
        String loginData = null;
        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowCount - 1][columnCount];
        for (i=1; i< rowCount;i++){
            for (j=0;j<columnCount;j++){
                loginData = sheet.getRow(i).getCell(j).getStringCellValue();
                //System.out.print(loginData+ "|");
                data[i-1][j]=loginData;
            }

        }
        return data;
    }

    @DataProvider(name="Test1")
    public Object[][] getData() throws IOException {
        String path = "C://Users//premkumar.sarathi//Downloads//Book2.xlsx";
        Object[][] data=testData(path, "SwagLabs");
        return data;
    }
}
