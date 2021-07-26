import base.TestBase;
import com.codoid.products.exception.FilloException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase2 extends TestBase {
    @BeforeClass(description = "open website, extract data from exel, delete old records")
    public void preparetc2() throws FilloException {
        regPage.open();
        regPage.extractValues();
        regPage.deleteOldRecords();
    }

    @Test(priority=1, testName = "enter userinput, check error message, save screenshot")
    public void userInput() throws FilloException, IOException {
        regPage.addValue(regPage.userInput, regPage.word[1]);
        regPage.checkError("userInput", regPage.userError);
        regPage.saveScreenshotTC2("userInput");
    }
    @Test(priority=2, testName = "enter passInput, check error message, save screenshot")
    public void passInput() throws FilloException, IOException {
        regPage.addValue(regPage.passInput, regPage.word[2]);
        regPage.checkError("passInput", regPage.passError);
        regPage.saveScreenshotTC2("passInput");
    }

    @Test(priority=3, testName = "enter confirmPassInput, check error message, save screenshot")
    public void confirmPassInput() throws FilloException, IOException {
        regPage.addValue(regPage.confirmPassInput, regPage.word[3]);
        regPage.checkError("confirmPassInput", regPage.confirmPassError);
        regPage.saveScreenshotTC2("confirmPassInput");
    }

    @Test(priority=4, testName = "enter nameInput, check error message, save screenshot")
    public void nameInput() throws FilloException, IOException {
        regPage.addValue(regPage.nameInput, regPage.word[4]);
        regPage.checkError("nameInput", regPage.nameError);
        regPage.saveScreenshotTC2("nameInput");
    }

    @Test(priority=5, testName = "enter surnameInput, check error message, save screenshot")
    public void surnameInput() throws FilloException, IOException {
        regPage.addValue(regPage.surnameInput, regPage.word[5]);
        regPage.checkError("surnameInput", regPage.surnameError);
        regPage.saveScreenshotTC2("surnameInput");
    }

    @Test(priority=6, testName = "enter emailInput, check error message, save screenshot")
    public void emailInput() throws FilloException, IOException {
        regPage.addValue(regPage.emailInput, regPage.word[6]);
        regPage.checkError("emailInput", regPage.emailError);
        regPage.saveScreenshotTC2("emailInput");
    }

    @Test(priority=7, testName = "enter nickInput, check error message, save screenshot")
    public void nickInput() throws FilloException, IOException {
        regPage.addValue(regPage.nickInput, regPage.word[7]);
        regPage.checkError("nickInput", regPage.nickError);
        regPage.saveScreenshotTC2("nickInput");
    }
}
