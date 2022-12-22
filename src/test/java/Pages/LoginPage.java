package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    By customerLoginBtn = By.xpath(".//*[text()='Customer Login']");
    By managerLoginBtn = By.xpath(".//*[text()='Bank Manager Login']");


    public void clickLogin(String loginby, WebDriver driver) throws Throwable {
        if (loginby.equals("Customer")) {
            driver.findElement(customerLoginBtn).click();
        } else {
            driver.findElement(managerLoginBtn).click();
        }
    }

}
