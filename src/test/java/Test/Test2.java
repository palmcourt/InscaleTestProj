package Test;

import Pages.AccountPage;
import Pages.CustomerPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class Test2 extends BaseClass {


    @Test
    public void Test_two() throws Throwable {


        LoginPage login = new LoginPage();
        login.clickLogin("Customer", driver);
        CustomerPage custPage = new CustomerPage();
        custPage.selectDropdown(driver, "Hermoine Granger");
        AccountPage accPage = new AccountPage();
        accPage.selectAccountNo(driver, "1003")
                .verifyAccountDetails(driver)
                .doTransaction(driver, "Deposit", 500)
                .doTransaction(driver, "Withdraw", 100).clickHomeBtn(driver);

    }
}
