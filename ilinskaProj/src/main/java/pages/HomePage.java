package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//button[text()='Sign Out']")
    private Button buttonSignOut;
@FindBy(xpath = ".//a[text()='Create Post']")
private Button buttonCreatePost;
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public boolean isButtonSignOutPresent() {
        return isElementPresent(buttonSignOut);

    }

    public HomePage checkIsButtonSignOutVisible() {
        Assert.assertTrue("Button Sign Out is not displayed ", isButtonSignOutPresent());
        return this;
    }
    public CreatePostPage clickonButtonCreatePost(){
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }
}

