package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class PostPage extends ParentPage {
    @FindBy(xpath = ".//button[@data-original-title='Delete']")
    private Button buttonDeletePost;

    @FindBy(xpath = ".//*[@class='alert alert-success text-center']")
    private TextBlock successMessageElement;

    @FindBy(xpath = ".//img[@data-original-title='My Profile']")
    private Button buttonProfile;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/post/";
    }

    public PostPage checkIsRedirectedOnPostPage() {
        checkUrlWithPattern();
        checkIsButtonDeletePresent();
        return this;
    }

    public PostPage checkIsButtonDeletePresent() {
        Assert.assertTrue("Button 'Delete post' is not present", isElementPresent(buttonDeletePost));
        return this;
    }

    public PostPage checkIsSuccessMessagePresent() {
        Assert.assertTrue("Success message is not present", isElementPresent(successMessageElement));
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text) {
        String actualText = successMessageElement.getText();
        Assert.assertEquals("Text in message ", text, actualText);
        return this;
    }

    public ProfilePage clickOnButtonProfile() {
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }

    public ProfilePage clickOnButtonDelete() {
        clickOnElement(buttonDeletePost);
        return new ProfilePage(webDriver);
    }
}
