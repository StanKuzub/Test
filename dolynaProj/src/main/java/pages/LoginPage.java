package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {


    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath =" .//button[text()='Sign In']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        try {
            webDriver.get("https://qa-complex-app-for-testing.herokuapp.com/");
            logger.info("Login page was opened");
        }catch (Exception e){
            logger.error("Can not work with LoginPage" + e);
            Assert.fail("Can not work with LoginPage");

        }
    }

    public void enterLoginInSignIn(String login) {
      //  try{
           // WebElement element = webDriver.findElement(By.xpath(".//input[@placeholder='Username']"));
           // element.clear();
            //element.sendKeys(login);
          //  logger.info(login + "was inputted in SignIn input login");

      //  }catch (Exception e){
         //   logger.error("Can not work with element" + e);
          //  Assert.fail("Can not work with element" + e);
        //}
        enterTextToElement(inputLogin, login);

    }

    public void enterPassWordInSignIn(String passWord) {
        enterTextToElement(inputPassword, passWord);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);

    }
    public void fillLoginFormAndSubmit(String login, String passWord){
        openLoginPage();
        enterLoginInSignIn(login);
        enterPassWordInSignIn(passWord);
        clickOnButtonSignIn();

    }
    public HomePage loginWithValidCread(){
        fillLoginFormAndSubmit(TestData.VALID_LOGIN, TestData.VALID_PASSWORD);
        return new HomePage(webDriver);
    }
}
