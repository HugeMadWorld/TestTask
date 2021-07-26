import base.TestBase;
import com.codoid.products.exception.FilloException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCase3 extends TestBase {
    @DataProvider(name = "excel")
    public Object[][] dbData() throws FilloException {
        regPage.extract();
        regPage.getValues();
        return new Object[][]{
                {regPage.user[1],regPage.pass[1],regPage.confirmpassword[1],regPage.name[1],regPage.surname[1],regPage.email[1],regPage.nick[1],"Test1"},
                {regPage.user[2],regPage.pass[2],regPage.confirmpassword[2],regPage.name[2],regPage.surname[2],regPage.email[2],regPage.nick[2],"Test2"},
                {regPage.user[3],regPage.pass[3],regPage.confirmpassword[3],regPage.name[3],regPage.surname[3],regPage.email[3],regPage.nick[3],"Test3"},
                {regPage.user[4],regPage.pass[4],regPage.confirmpassword[4],regPage.name[4],regPage.surname[4],regPage.email[4],regPage.nick[4],"Test4"},
                {regPage.user[5],regPage.pass[5],regPage.confirmpassword[5],regPage.name[5],regPage.surname[5],regPage.email[5],regPage.nick[5],"Test5"},
                {regPage.user[6],regPage.pass[6],regPage.confirmpassword[6],regPage.name[6],regPage.surname[6],regPage.email[6],regPage.nick[6],"Test6"}
        };
    }

    @Test(dataProvider = "excel", testName = "Set all input fields, click submit, check error message, save screenshot")
    public void tc3(String user, String pass, String confirmpass, String name, String surname, String email, String nick, String testnumber) throws IOException {
        regPage.open();
        regPage.addValue(regPage.userInput, user);
        regPage.addValue(regPage.passInput, pass);
        regPage.addValue(regPage.confirmPassInput, confirmpass);
        regPage.addValue(regPage.nameInput, name);
        regPage.addValue(regPage.surnameInput, surname);
        regPage.addValue(regPage.emailInput, email);
        regPage.addValue(regPage.nickInput, nick);
        regPage.checkErrors();
        regPage.saveScreenshotTC3(testnumber);
        regPage.closeConn();
    }

}
