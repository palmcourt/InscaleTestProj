package Pages;

import Test.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerPage extends BaseClass {

    By addCustomer=By.xpath(".//button[contains(text(),'Add Customer')]");
    By openAccount=By.xpath(".//button[contains(text(),'Open Account')]");
    By customers=By.xpath(".//button[contains(text(),'Customers')]");

    public void clickAddCustomer(WebDriver driver){
        driver.findElement(addCustomer).click();
    }

}
