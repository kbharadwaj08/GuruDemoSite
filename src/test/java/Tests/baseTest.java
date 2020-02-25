package Tests;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseTest {

    public Properties objProp = new Properties();
    FileInputStream readProp;
    FileOutputStream writeProp;
        {
        try {
            readProp = new FileInputStream("C:\\Users\\kiran\\IdeaProjects\\SelProject2\\src\\test\\java\\appDetails.properties");
            objProp.load(readProp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws FileNotFoundException {
        System.setProperty(objProp.getProperty("browser"),objProp.getProperty("driverPath"));
        String fileSuffix = DateTime.now().toString("yyyy-dd-MM-HH-mm-ss");
        objProp.setProperty("RunCount", fileSuffix);
        String folderName = objProp.getProperty("folderPlaceHolder")+"_"+objProp.getProperty("RunCount");
        objProp.setProperty("screenshotFolder", folderName);
        new File(objProp.getProperty("screenshotPath")+folderName).mkdir();
        writeProp = new FileOutputStream("C:\\Users\\kiran\\IdeaProjects\\SelProject2\\src\\test\\java\\appDetails.properties");
        objProp.save(writeProp,"updated Screenshot folder");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(objProp.getProperty("URL"));

    }

    @AfterSuite
    public void afterSuite() throws FileNotFoundException {

        if(null != driver)
        {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
