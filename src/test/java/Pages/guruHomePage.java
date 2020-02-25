package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruHomePage {

    WebDriver driver;

    @FindBy(xpath="//tr[@class='heading3']")
    WebElement titleValidation;

    @FindBy(xpath="//a[text()='Log out']")
    WebElement logOutLink;



    public guruHomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String validateLogin()
    {
        return titleValidation.getText();
    }

    public void logoutApp()
    {
        logOutLink.click();
    }


}
