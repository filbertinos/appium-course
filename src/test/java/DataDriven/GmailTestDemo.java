package DataDriven;

//Prerequisite Lectures - Excel API Methods explanation + dataprovider annotation
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class GmailTestDemo {
    XSSFWorkbook excelWorkbook = null;
    XSSFSheet excelSheet = null;
    XSSFRow row = null;
    XSSFCell cell = null;
    WebDriver driver = null;
    @Test(dataProvider = "getData") //dataProvider value should be equal to @DataProvider method name
    public void doLogin(String username, String password,String browser) { //no. of parameter = no. of columns
        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        } else if(browser.equals("chrome"))
        {
            driver=new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://gmail.com");
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
        driver.findElement(By.id("next")).click();
        driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(Keys.ENTER);
        driver.quit();
    }
    @DataProvider // supplying data for a test method.
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("TestData.xlsx"); // Your .xlsx file name along with path
        excelWorkbook = new XSSFWorkbook(fis);
// Read sheet inside the workbook by its name
        excelSheet = excelWorkbook.getSheet("Sheet1"); //Your sheet name
// Find number of rows in excel file
        System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
                + excelSheet.getLastRowNum());
        int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
        int colCount = excelSheet.getRow(0).getLastCellNum();
        System.out.println("Row Count is: " + rowCount
                + " *** Column count is: " + colCount);
        Object data[][] = new Object[rowCount-1][colCount];
        for (int rNum = 2; rNum <= rowCount; rNum++) {
            for (int cNum = 0; cNum < colCount; cNum++) {
                System.out.print(getCellData("Sheet1", cNum, rNum) + " "); // Your sheet name
                data[rNum - 2][cNum] = getCellData("Sheet1", cNum, rNum); //Your sheet name
            }
            System.out.println();
        }
        return data;
    }
    // Function will always used as below. It returns the data from a cell - No need to make any changes
    public String getCellData(String sheetName, int colNum, int rowNum) {
        try {
            if (rowNum <= 0)
                return "";
            int index = excelWorkbook.getSheetIndex(sheetName);
            if (index == -1)
                return "";
            excelSheet = excelWorkbook.getSheetAt(index);
            row = excelSheet.getRow(rowNum - 1);
            if (row == null)
                return "";
            cell = row.getCell(colNum);
            if (cell == null)
                return "";
            if (cell.getCellType() == Cell.CELL_TYPE_STRING)
                return cell.getStringCellValue();
            else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
                    || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                String cellText = String.valueOf(cell.getNumericCellValue());
                return cellText;
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        } catch (Exception e) {
            e.printStackTrace();
            return "row " + rowNum + " or column " + colNum
                    + " does not exist in xls";
        }
    }
}