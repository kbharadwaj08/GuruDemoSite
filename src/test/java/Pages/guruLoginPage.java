package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruLoginPage{

    WebDriver driver;

    @FindBy(className = "site-name")
    WebElement pageTitle;

    @FindBy(name="uid")
    WebElement loginName;

    @FindBy(name="password")
    WebElement pwd;

    @FindBy(name="btnLogin")
    WebElement loginButton;

    public guruLoginPage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitle()
    {return pageTitle.getText();}

    public void setUsername(String username)
    { loginName.sendKeys(username);}

    public void setPassword(String password)
    {pwd.sendKeys(password);}

    public void clickLogin()
    {loginButton.click();}

    public boolean loginButtonVisible()
    {
        return loginButton.isDisplayed();
    }

    public void loginAction(String uname, String pword)
    {
        this.setUsername(uname);
        this.setPassword(pword);
        this.clickLogin();
    }
}
