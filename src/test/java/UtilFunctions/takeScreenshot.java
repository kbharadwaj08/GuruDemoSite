package UtilFunctions;
import Tests.baseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.joda.time.DateTime;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class takeScreenshot{

    public void screenshot(WebDriver driver, String Path) throws IOException {
        String fileSuffix = DateTime.now().toString("yyyy-dd-MM-HH-mm-ss");
        TakesScreenshot ss = ((TakesScreenshot)driver);
        File srcFile = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(Path+fileSuffix+".jpg"));
    }

}
