package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPage{
//    кнопка удаления
    @FindBy(xpath = ".//button[@data-original-title='Delete']")
    private WebElement buttonDelete;
//    елемент с сообщением об успешном сохранении
    @FindBy(xpath = ".//*[@class='alert alert-success text-center']")
    private WebElement successMessageElement;
//    кнопка профиля
    @FindBy(xpath = ".//img[@data-original-title='My Profile']")
    private WebElement buttonProfile;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsButtonDeletePresent(){
//        наличие кнопки удалить
        Assert.assertTrue("Button Delete is not present", isElementPresent(buttonDelete));
        return this;
    }

    public PostPage checkSuccessMessagePresent(){
//        проверка наличия текст сообщения
        Assert.assertTrue("Success message is not present", isElementPresent(successMessageElement));
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text){
//        проверка наличия элемента с сообщением
        String actualText = successMessageElement.getText();
        Assert.assertEquals("Text is message", text, actualText);
        return this;
    }

    public ProfilePage clickOnButtonProfile(){
        clickOnElement(buttonProfile);
        return new ProfilePage(webDriver);
    }

}
