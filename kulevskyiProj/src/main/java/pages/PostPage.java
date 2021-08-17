package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPage {
    @FindBy (xpath = ".//button[@data-original-title='Delete']")
    private WebElement buttonDelete;
    @FindBy (xpath = ".//*[@class='alert alert-success text-center']")
    private WebElement successMassageElement;
    @FindBy (xpath = ".//img[@data-original-title='My Profile']")
    private WebElement buttonProfile;

    public PostPage (WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsButtonDeletePresent(){
        Assert.assertTrue("Button Delete is not present", isElementPresent(buttonDelete));
        return this;
    }

    public PostPage checkIsSuccessMassagePresent() {
        Assert.assertTrue("", isElementPresent(successMassageElement));
        return this;
    }

    public PostPage checkTextInSuccessMassage(String text){
        String actualText = successMassageElement.getText();
        Assert.assertEquals("Text in message", text, actualText);
        return this;
    }

    public ProfilePage clickOnButtonProfile() {
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }


    public ProfilePage clickOnDeleteButton() {
        clickOnElement(buttonDelete);
        return new ProfilePage(webDriver);
    }
}