package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruEditCustomer {

    WebDriver driver;

    @FindBy(xpath="//p[text()='Edit Customer Form']")
    WebElement pageTitle;

    @FindBy(xpath = "//table/tbody/tr[6]/td[2]/input")
    WebElement editCusID;

    @FindBy(xpath = "//table/tbody/tr[11]/td[2]/input[1]")
    WebElement submitButton;

    public guruEditCustomer( WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String verifyPageTitle()
    { return pageTitle.getText(); }

    public void enterEditCusId(String eCusID)
    { editCusID.sendKeys(eCusID);}

    public void clickSubmit()
    { submitButton.click();}

}
