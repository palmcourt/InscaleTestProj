package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    static WebDriver driver = null;

    @BeforeTest
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//java//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login.");

    }

    @AfterTest
    public void burnDown() {
        driver.quit();
    }

}
