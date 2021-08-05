package pages;

import libs.TestData;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputLogin;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassWord;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//div[text()='Invalid username / password']")
    private WebElement alertInvalidUsernamePassword;

    @FindBy(id = "username-register")
    private WebElement inputLoginRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPassWordRegistration;

    @FindBy(xpath = ".//button[text()='Sign up for OurApp']")
    private WebElement buttonSignUp;

    @FindBy(xpath = ".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    private List<WebElement> actualListOfErrors;

    final String listErrorsLocator = ".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    @FindBy(xpath = ".//div[text()='Username must be at least 3 characters.']")
    private WebElement alertInvalidUsernameRegistration;

    @FindBy(xpath = ".//div[text()='You must provide a valid email address.']")
    private WebElement alertInvalidEmailRegistration;

    @FindBy(xpath = ".//div[text()='Password must be at least 12 characters.']")
    private WebElement alertInvalidPasswordRegistration;

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
//        try{
////            WebElement element = webDriver.findElement(By.xpath(".//input[@placeholder='Username']"));
//            inputLogin.clear();
//            inputLogin.sendKeys(login);
//            logger.info(login + " was inputted in SignIn input login");
//
//        }catch (Exception e){
//            logger.error("Can not work with element" + e);
//            Assert.fail("Can not work with element" + e);
//        }
        enterTextToElement(inputLogin, login);
    }

    public void enterPassWordInSignIn(String passWord) {
        enterTextToElement(inputPassWord, passWord);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void fillLoginFormAndSubmit(String login, String passWord) {
        openLoginPage();
        enterLoginInSignIn(login);
        enterPassWordInSignIn(passWord);
        clickOnButtonSignIn();
    }

    public boolean isButtonSignInPresent() {
        return isElementPresent(buttonSignIn);
    }

    public boolean isAlertInvalidUsernamePasswordDisplayed() {
        return isElementPresent(alertInvalidUsernamePassword);
    }

    public LoginPage enterLoginInRegistration(String login) {
        enterTextToElement(inputLoginRegistration, login);
        return this;
    }

    public LoginPage enterEmailInRegistration(String email) {
        enterTextToElement(inputEmailRegistration, email);
        return this;
    }

    public LoginPage enterPassWordInRegistration(String passWord) {
        enterTextToElement(inputPassWordRegistration, passWord);
        return this;
    }

    public void clickOnButtonSignUp() {
        clickOnElement(buttonSignUp);
    }

    public boolean isAlertInvalidUsernameRegistrationDisplayed() {
        return isElementPresent(alertInvalidUsernameRegistration);
    }

    public boolean isAlertInvalidEmailRegistrationDisplayed() {
        return isElementPresent(alertInvalidEmailRegistration);
    }

    public boolean isAlertInvalidPasswordRegistrationDisplayed() {
        return isElementPresent(alertInvalidPasswordRegistration);
    }

    public HomePage loginWithValidCred(){
        fillLoginFormAndSubmit(TestData.VALID_LOGIN,TestData.VALID_PASSWORD);
        return new HomePage(webDriver);
    }

    public boolean isErrorExpected(String [] errorsExpectedArray, WebElement errorOnPage){
        for (int i = 0; i < errorsExpectedArray.length; i++){
            if (errorOnPage.getText().equals(errorsExpectedArray[i])){
                return true;
            }
        }
        return false;
    }

    public boolean checkErrors(String errors) {
        String[] errorsExpectedList = errors.split(";");
        List<WebElement> errorsOnPageList = webDriver.findElements(By.xpath(".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
        if (errorsExpectedList.length == errorsOnPageList.size()) {
                for (int i = 0; i < errorsOnPageList.size(); i++) {
                    if (!isErrorExpected(errorsExpectedList, errorsOnPageList.get(i))){
                        return false;
                    }
                }
                return true;
        }
        return false;
    }

    public void checkErrorsMessages(String expectedErrors) {
        String[] errorsArray = expectedErrors.split(";");
        webDriverWait10.withMessage("Number Of Messages ")
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath(listErrorsLocator), errorsArray.length));
//        Assert.assertEquals(actualListOfErrors.size(), errorsArray.length);

        SoftAssertions softAssertions = new SoftAssertions();
        ArrayList<String> actualTextFromErrors = new ArrayList<>();
        for (WebElement element: actualListOfErrors) {
            actualTextFromErrors.add(element.getText());
        }
        for (int i = 0; i < errorsArray.length; i++) {
            softAssertions.assertThat(errorsArray[i]).isIn(actualTextFromErrors);
        }
        softAssertions.assertAll();
    }
}