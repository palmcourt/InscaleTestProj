package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {

    By firstName= By.xpath(".//*[@placeholder='First Name']");
    By lastName= By.xpath(".//*[@placeholder='Last Name']");
    By postCode= By.xpath(".//*[@placeholder='Post Code']");
    By addCustomerBtn= By.xpath(".//*[text()='Add Customer']");
    By customers=By.xpath(".//button[contains(text(),'Customers')]");
    By homeButton = By.xpath(".//*[text()='Home']");

    public void addCustomer(WebDriver driver,String fName, String lName, String pCode) throws Throwable {

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postCode).sendKeys(pCode);
        driver.findElement(addCustomerBtn).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.findElement(homeButton).click();

    }

    public void clickOnCustomer(WebDriver driver){
        driver.findElement(customers).click();
    }

}
