package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruAddCustomer {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='New Customer']")
    WebElement newCustomer;

    @FindBy(xpath="//td/p[text()='Add New Customer']")
    WebElement pageTitle;

    @FindBy(xpath="//table/tbody/tr[4]/td[2]/Input")
    WebElement cusName;

    @FindBy(xpath="//table/tbody/tr[6]/td[2]/Input")
    WebElement dob;

    @FindBy(xpath="//table/tbody/tr[7]/td[2]/textarea")
    WebElement addrBox;

    @FindBy(xpath="//table/tbody/tr[8]/td[2]/input")
    WebElement city;

    @FindBy(xpath="//table/tbody/tr[9]/td[2]/input")
    WebElement state;

    @FindBy(xpath="//table/tbody/tr[10]/td[2]/input")
    WebElement pin;

    @FindBy(xpath="//table/tbody/tr[11]/td[2]/input")
    WebElement mobile;

    @FindBy(xpath="//table/tbody/tr[12]/td[2]/input")
    WebElement email;

    @FindBy(xpath="//table/tbody/tr[13]/td[2]/input")
    WebElement custPassword;

    @FindBy(xpath="//table/tbody/tr[14]/td[2]/input[1]")
    WebElement submitButton;

    @FindBy(xpath="//table/tbody/tr[14]/td[2]/input[2]")
    WebElement resetButton;

    @FindBy(xpath="//table/tbody/tr[4]/td[2]")
    WebElement customerID;

    @FindBy(xpath="//a[text()='Edit Customer']")
    WebElement editCustomerlink;

    public guruAddCustomer(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToNewCustomer()
    { newCustomer.click(); }

    public String getPageTitle()
    {
        return pageTitle.getText();
    }

    public void enterCustomerName(String cname)
    {
        cusName.sendKeys(cname);
    }

    public void enterdob(String cdob)
    {
        dob.sendKeys(cdob);
    }

    public void enterAddress(String cAddr)
    {
        addrBox.sendKeys(cAddr);
    }

    public void enterCity(String cCity)
    {
        city.sendKeys(cCity);
    }

    public void enterState(String cState)
    {
        state.sendKeys(cState);
    }

    public void enterPIN(String cPIN)
    {
        pin.sendKeys(cPIN);
    }

    public void enterMNumber(String cMobileNo)
    {
        mobile.sendKeys(cMobileNo);
    }

    public void enterEmail(String cEmail)
    {
        email.sendKeys(cEmail);
    }

    public void enterCusPassword(String cPassword)
    {
        custPassword.sendKeys(cPassword);
    }

    public void clickSubmit()
    {
        submitButton.click();
    }

    public String readCustID()
    {
        return customerID.getText();
    }

    public void navigateToEditCus()
    {
        editCustomerlink.click();
    }

}
