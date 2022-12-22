package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CustomerListPage {

    By customers = By.xpath("//table//tbody//td[1]");
    By search_box = By.xpath(".//*[@placeholder='Search Customer']");
    By deleteButton = By.xpath(".//*[text()='Delete']");
    By homeButton = By.xpath(".//*[text()='Home']");

    public void searchByCustomer(WebDriver driver, String customerName) {
        driver.findElement(search_box).sendKeys(customerName);
    }

    public CustomerListPage deleteCustomer(WebDriver driver, String fname, String lNmae, String postCode) {

        driver.findElement(By.xpath(".//td[text()='" + fname + "']//following::td[text()='" + lNmae + "']//following::td[text()='" + postCode + "']//following::button[1]")).click();
        System.out.println("Customer deleted : " + fname + "_" + lNmae + "_" + postCode + "   Successfully");
        driver.findElement(search_box).clear();
        return this;
    }

    public void verifyAddedCustomers(WebDriver driver, List<String> addedCustomers) {

        List<WebElement> customerList = driver.findElements(customers);
        List<String> cust_List = new ArrayList<>();
        for (WebElement list : customerList) {
            cust_List.add(list.getText());
        }
        Assert.assertTrue(cust_List.containsAll(addedCustomers), "Customers not added successfully");
        System.out.println("Customers added successfully" + addedCustomers);
    }

    public LoginPage clickHomeButton(WebDriver driver) {
        driver.findElement(homeButton).click();
        return new LoginPage();
    }
}
