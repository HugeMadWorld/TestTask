package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobj.RegPage;

public class TestBase {
    public static WebDriver driver;
    public static RegPage regPage;

    @BeforeTest
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "..//mainProj//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        regPage = new RegPage(driver);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
