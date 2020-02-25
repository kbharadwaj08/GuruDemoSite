package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class guruEditCustDetails {

    WebDriver driver;

    @FindBy(xpath = "//table/tbody/tr[4]/td[2]/input")
    WebElement custName;

    @FindBy(xpath = "//table/tbody/tr[7]/td[2]/textarea")
    WebElement custAddr;

    @FindBy(xpath = "//table/tbody/tr[8]/td[2]/input")
    WebElement custCity;

    @FindBy(xpath = "//table/tbody/tr[9]/td[2]/input")
    WebElement custState;

    @FindBy(xpath = "//table/tbody/tr[13]/td[2]/input[1]")
    WebElement custSubmit;

    public guruEditCustDetails(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getcustName()
    {return custName.getAttribute("value");}

    public String getcustAddr()
    {return custAddr.getAttribute("value");}

    public String getCity()
    {return custCity.getAttribute("value");}

    public String getState()
    {return custState.getAttribute("value");}

    public void setEditAddr(String editAddr)
    { custAddr.sendKeys(editAddr); }

    public void setEditCity(String editCity)
    {custCity.sendKeys(editCity); }

    public void setEditState( String editState)
    {custState.sendKeys(editState);}

    public void clickSubmit()
    {custSubmit.click();}

}
