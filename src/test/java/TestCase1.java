import base.TestBase;
import org.testng.annotations.*;

public class TestCase1 extends TestBase {

    @Test(priority=1, testName = "open mainpage link, verify, go back")
    public void mainPage() {
        regPage.open();
        regPage.mainPageLink.click();
        regPage.verify(regPage.mainPageVerify);
        driver.navigate().back();
    }

    @Test(priority=2, testName = "open projects link, verify, go back")
    public void projects() {
        regPage.projectsLink.click();
        regPage.verify(regPage.projectsVerify);
        driver.navigate().back();
    }

    @Test(priority=3, testName = "open projects link, verify, go back")
    public void help() {
        regPage.helpLink.click();
        regPage.verify(regPage.helpVerify);
        driver.navigate().back();
    }

    @Test(priority=4, testName = "open login link, verify, go back")
    public void login() {
        regPage.loginLink.click();
        regPage.verify(regPage.loginVerify);
        driver.navigate().back();
    }

    @Test(priority=5, testName = "open footer link, verify, go back")
    public void footer() {
        regPage.footerLink.click();
        regPage.verify(regPage.footerVerify);
        driver.navigate().back();
    }

}
