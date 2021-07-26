package pageobj;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class RegPage {
    private WebDriver driver;
    private Fillo fillo = new Fillo();
    private Connection connection;
    private Recordset recordset;
    private String strQuery;
    private String result;
    public String[] user = new String[10];
    public String[] pass = new String[10];
    public String[] confirmpassword = new String[10];
    public String[] name = new String[10];
    public String[] surname = new String[10];
    public String[] email = new String[10];
    public String[] nick = new String[10];
    public String[] word = new String[10];


    @FindBy(className = "home")
    public WebElement mainPageLink;
    @FindBy(className = "projects")
    public WebElement projectsLink;
    @FindBy(className = "help")
    public WebElement helpLink;
    @FindBy(className = "login")
    public WebElement loginLink;
    @FindBy(css = "[href=\"http://www.redmine.org/\"]")
    public WebElement footerLink;

    public String mainPageVerify = "https://www.redmine.org/";
    public String projectsVerify = "https://www.redmine.org/projects";
    public String helpVerify = "https://www.redmine.org/guide";
    public String loginVerify = "https://www.redmine.org/login";
    public String footerVerify = "https://www.redmine.org/";

    @FindBy(id = "user_login")
    public WebElement userInput;
    @FindBy(id = "user_password")
    public WebElement passInput;
    @FindBy(id = "user_password_confirmation")
    public WebElement confirmPassInput;
    @FindBy(id = "user_firstname")
    public WebElement nameInput;
    @FindBy(id = "user_lastname")
    public WebElement surnameInput;
    @FindBy(id = "user_mail")
    public WebElement emailInput;
    @FindBy(id = "user_custom_field_values_3")
    public WebElement nickInput;
    @FindBy(css = "[name=\"commit\"]")
    public WebElement acceptBtn;
    @FindBy(xpath = "//*[@id=\"errorExplanation\"]/ul")
    public WebElement errorLabel;

    public String userError = "Login";
    public String passError = "Password is";
    public String confirmPassError = "Password doesn't";
    public String nameError = "First";
    public String surnameError = "Last";
    public String emailError = "Email";
    public String nickError = "https://www.redmine.org/login";

    public void open() {
        driver.get("https://www.redmine.org/account/register");
    }

    public void verify(String verify) {
        Assert.assertTrue(driver.getCurrentUrl().equals(verify));
    }

    public RegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void extractValues() throws FilloException {
        connection=fillo.getConnection("excel.xlsx");
        strQuery="Select * from sheet1";
        recordset=connection.executeQuery(strQuery);
        try {
            for (int x = 1; x <=100; x++){
                recordset.next();
                word[x] = recordset.getField("Value");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteOldRecords() throws FilloException {
        strQuery = "DELETE FROM sheet2";
        connection.executeUpdate(strQuery);
    }

    public void extract() throws FilloException {
        connection=fillo.getConnection("excel.xlsx");
        strQuery="Select * from sheet3";
        recordset=connection.executeQuery(strQuery);
    }

    public void getValues() {
        try {
            for (int x = 1; x<=100; x++){
                recordset.next();
                user[x] = recordset.getField("Username");
                pass[x] = recordset.getField("Password");
                confirmpassword[x] = recordset.getField("ConfirmPassword");
                name[x] = recordset.getField("Name");
                surname[x] = recordset.getField("Surname");
                email[x] = recordset.getField("Email");
                nick[x] = recordset.getField("Nick");
            }
       }catch (Exception e){System.out.println(e);}
    }

    public void addValue(WebElement element, String input) {
        element.sendKeys(input);
    }

    public void checkErrors() {
        acceptBtn.click();
        Assert.assertTrue(errorLabel.isDisplayed());
    }

    public void closeConn(){
        recordset.close();
        connection.close();
    }

    public void checkError(String elname,String elemError) throws FilloException {
        acceptBtn.click();
        Assert.assertTrue(errorLabel.isDisplayed());
        if (errorLabel.getText().contains(elemError)) {
            result = "fail";
        } else {
            result = "pass";
        }
        strQuery = "INSERT INTO sheet2 (Result) VALUES ('"+elname+"="+result+"')";
        connection.executeUpdate(strQuery);
    }

    public void saveScreenshotTC2(String elname) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("tc2\\" + elname + ".png"));
    }

    public void saveScreenshotTC3(String elname) throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("tc3\\" + elname + ".png"));
    }
}