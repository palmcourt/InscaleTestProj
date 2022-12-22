package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static java.lang.Thread.sleep;
import static org.testng.Assert.assertEquals;

public class AccountPage {

    By accountNo = By.id("accountSelect");
    By accDetails = By.xpath("(.//*[@ng-hide='noAccount'])[2]");
    By transactionsButton = By.xpath(".//button[contains(text(),'Transactions')]");
    By depositButton = By.xpath(".//button[contains(text(),'Deposit')]");
    By depositSubmitButton = By.xpath(".//button[contains(text(),'Deposit') and @type='submit']");
    By withdrawButton = By.xpath(".//button[contains(text(),'Withdrawl')]");
    By withdrawSubmitButton = By.xpath(".//button[contains(text(),'Withdraw') and @type='submit']");
    By depositTextBox = By.xpath(".//*[@ng-model='amount']");
    By messageAlert = By.xpath(".//*[@ng-show='message']");
    By transactionAmount = By.xpath(".//tbody//tr[last()]/td[2]");
    By transactionDetails = By.xpath(".//tbody//tr[last()]/td[3]");
    By backButton = By.xpath(".//button[text()='Back']");
    By homeButton = By.xpath(".//button[text()='Home']");

    public AccountPage selectAccountNo(WebDriver driver, String accNo) {

        Select select = new Select(driver.findElement(accountNo));
        select.selectByVisibleText(accNo);
        return this;

    }

    public AccountPage verifyAccountDetails(WebDriver driver) {
        String balance = driver.findElement(accDetails).getText().split(",")[1].trim();
        Assert.assertTrue(balance.equals("Balance : 0"), "Balance was not matched");
        return this;
    }

    public AccountPage doTransaction(WebDriver driver, String transactionType, int amount) throws Throwable {

        String beforeBalance = driver.findElement(accDetails).getText().split(",")[1].trim().split(":")[1].trim();

        if (transactionType.equals("Deposit")) {

            driver.findElement(depositButton).click();
            driver.findElement(depositTextBox).sendKeys(String.valueOf(amount));
            driver.findElement(depositSubmitButton).click();
            assertEquals(driver.findElement(messageAlert).getText().trim(), "Deposit Successful");
            String afterBalance = driver.findElement(accDetails).getText().split(",")[1].trim().split(":")[1].trim();
            assertEquals(Integer.valueOf(beforeBalance) + amount, Integer.valueOf(afterBalance));
            System.out.println("Amount : " + amount + " - successfully deposited");
            System.out.println("Current balance : " + afterBalance);
            sleep(3000);
            driver.findElement(transactionsButton).click();
            assertEquals(String.valueOf(amount), driver.findElement(transactionAmount).getText());
            System.out.println("Transaction amount displayed in transactions");
            assertEquals("Credit", driver.findElement(transactionDetails).getText());
            System.out.println("Transaction type displayed in transactions");
            driver.findElement(backButton).click();

        } else {
            driver.findElement(withdrawButton).click();
            sleep(3000);
            driver.findElement(depositTextBox).sendKeys(String.valueOf(amount));
            driver.findElement(withdrawSubmitButton).click();
            assertEquals(driver.findElement(messageAlert).getText().trim(), "Transaction successful");
            String afterBalance = driver.findElement(accDetails).getText().split(",")[1].trim().split(":")[1].trim();
            assertEquals(Integer.valueOf(beforeBalance) - amount, Integer.valueOf(afterBalance));
            System.out.println("Amount : " + amount + " - successfully withdraw");
            System.out.println("Current balance : " + afterBalance);
            sleep(3000);
            driver.findElement(transactionsButton).click();
            assertEquals(String.valueOf(amount), driver.findElement(transactionAmount).getText());
            System.out.println("Transaction amount displayed in transactions");
            assertEquals("Debit", driver.findElement(transactionDetails).getText());
            System.out.println("Transaction type displayed in transactions");
            driver.findElement(backButton).click();

        }
        return this;
    }

    public LoginPage clickHomeBtn(WebDriver driver) {

        driver.findElement(homeButton).click();
        return new LoginPage();
    }

}
