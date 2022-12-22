package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {

    By dropdown = By.id("userSelect");
    By loginButton = By.xpath(".//button[text()='Login']");

    public void selectDropdown(WebDriver driver, String dropDownTest) {

        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(dropDownTest);
        driver.findElement(loginButton).click();
    }

}
