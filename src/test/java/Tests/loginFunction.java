package Tests;

import Pages.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Assert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import UtilFunctions.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;

public class loginFunction extends baseTest {

    guruLoginPage objLogin;
    guruHomePage objHome;
    guruAddCustomer objAddCus;
    guruEditCustomer objEditCus;
    guruEditCustDetails objEditDetails;
    takeScreenshot objSS = new takeScreenshot();

    String  sspath = objProp.getProperty("screenshotPath")+objProp.getProperty("screenshotFolder")+"\\";
        //takeScreenshot objSS = new takeScreenshot(driver);
    //readExcel readObj;

    @Test
    public void a_performLogin() throws IOException, InterruptedException {
        objLogin = new guruLoginPage(driver);
        String loginPageTitle = objLogin.getTitle();
        Assert.assertTrue(loginPageTitle.contains("Demo Site"));
        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);

        objLogin.loginAction(objProp.getProperty("appUsername"), objProp.getProperty("appPassword"));
        Thread.sleep(2000);

        objSS.screenshot(driver,sspath);
        objHome = new guruHomePage(driver);
        Assert.assertTrue(objHome.validateLogin().contains("Manger Id : mngr242657"));

    }

    @Test
    public void b_creatingCustomers() throws IOException, InterruptedException {
        objAddCus = new guruAddCustomer(driver);

        objAddCus.navigateToNewCustomer();
        Assert.assertTrue(objAddCus.getPageTitle().contains("Add New Customer"));

        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);

        objAddCus.enterCustomerName(readFromExcel(0));
        objAddCus.enterdob(readFromExcel(1));
        objAddCus.enterAddress(readFromExcel(2));
        objAddCus.enterCity(readFromExcel(3));
        objAddCus.enterState(readFromExcel(4));
        objAddCus.enterPIN(readFromExcel(5));
        objAddCus.enterMNumber(readFromExcel(6));
        objAddCus.enterEmail(readFromExcel(7));
        objAddCus.enterCusPassword(readFromExcel(8));


        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);

        objAddCus.clickSubmit();

        writeExcel(objAddCus.readCustID());
        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);
    }

    @Test
    public void c_EditCustomer() throws InterruptedException, IOException {

        objEditCus = new guruEditCustomer(driver);

        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);
        objAddCus.navigateToEditCus();
        Assert.assertTrue(objEditCus.verifyPageTitle().contains("Edit Customer Form"));

        objEditCus.enterEditCusId(readFromExcel(9));
        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);
        objEditCus.clickSubmit();

        Thread.sleep(2000);
        objSS.screenshot(driver,sspath);
        objEditDetails = new guruEditCustDetails(driver);

        Assert.assertTrue(objEditDetails.getcustName().contains(readFromExcel(0)));


    }

    /*@DataProvider(name = "DataInput")
    public Object[][] fetchData() throws IOException {

       Object[][] arrayObj = readFromExcel(objProp.getProperty("testData"));
       return arrayObj;
    }*/

    public String readFromExcel(int col)
    {
        String excelData = null;
        try {
            File file = new File(objProp.getProperty("testData"));

            FileInputStream readStream = new FileInputStream(file);

            XSSFWorkbook readWB = new XSSFWorkbook(readStream);

            XSSFSheet readSheet = readWB.getSheet("CustomerDetails");
            XSSFRow row = readSheet.getRow(0);

            int rcount = readSheet.getLastRowNum();
            CellType cellType = readSheet.getRow(rcount).getCell(col).getCellType();

            if( cellType == CellType.STRING)
                excelData = readSheet.getRow(rcount).getCell(col).getStringCellValue();
            else if( cellType == CellType.NUMERIC)
            {
                excelData = readSheet.getRow(rcount).getCell(col).getRawValue();
            }

         }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return excelData;
    }

    public void writeExcel(String input) throws IOException{
        //create an object of File Class to open xlsx file
        File file = new File(objProp.getProperty("testData"));

        //Create an object of FileInputStream class to read excel File
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);

        //find the file extension by splitting file name in substring and getting only extension name

        //Read excel sheet by sheet name
        XSSFSheet sheet = wb.getSheet("CustomerDetails");

        //Get the Current COunt of rows in excel file
        int rowCount = sheet.getLastRowNum()- sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        int colCount = row.getLastCellNum();

        sheet.getRow(rowCount).createCell(colCount-1).setCellValue(input);
        //sheet.createRow(rowCount).createCell(colCount).setCellValue(input);

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(file);

        wb.write(outputStream);

        outputStream.close();
    }

}
