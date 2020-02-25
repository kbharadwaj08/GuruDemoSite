package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class createNewCustomer extends baseTest{

    guruHomePage objHome;
    guruAddCustomer objAddCus;

    @Test
    public void creatingCustomers()
    {

        objAddCus = new guruAddCustomer(driver);

        objAddCus.navigateToNewCustomer();
        Assert.assertTrue(objAddCus.getPageTitle().contains("Add New Customer"));



    }
}
