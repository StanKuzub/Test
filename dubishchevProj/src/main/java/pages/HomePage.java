package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//button[text()='Sign Out']")
    private WebElement buttonSignOut;
    @FindBy(xpath = ".//a[text()='Create Post']")
    private WebElement buttonCreatePost;
    @FindBy(xpath = ".//img[@data-original-title='My Profile']")
    private WebElement buttonProfile;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonSignOutPresent() {
        return isElementPresent(buttonSignOut);
    }


    public HomePage checkIsButtonSignOutVisible() {
        Assert.assertTrue("Button SignOut not visible", isButtonSignOutPresent());
        return this;
    }

    public CreatePostPage clickOnButtonCreatePost() {
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }

    public ProfilePage clickOnProfileButton() {
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }

    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (!isButtonSignOutPresent()) {
            loginPage.loginWithValidCred();
        }
        return this;
    }
}
