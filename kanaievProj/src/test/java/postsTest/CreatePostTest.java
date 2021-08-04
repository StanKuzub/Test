package postsTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;

public class CreatePostTest extends BaseTest {
    private final String POST_TITLE = "Pasha newbie title-" + Util.getDateAndTimeFormatted();

    @Test
    public void createPost() {
        loginPage
                .loginWithValidCred()
                .checkIsButtonSignOutVisible()
                .clickOnButtonCreatePost()
                .checkIsInputTitlePresent()
                .enterTextIntoInputTitle(POST_TITLE)
                .enterTextIntoInputBody("Body text")
//                .selectTextInDDSelectValue("Частное сообщение")
                .selectValueInDDSelectValue("One Person")
                .clickButtonSaveNewPost()
                .checkIsButtonDeletePresent()
                .checkIsAlertElementPresent()
                .checkTextInSuccessMessage("New post successfully created.")
                .clickOnButtonProfile()
                .checkIsPostWasAdded(POST_TITLE)
        ;
    }

    @After
    public void deletePost() {
        homePage
                .openHomePage()
                .checkIsButtonSignOutVisible()
                .clickOnButtonProfile()
                .deletePostWithTitleWhilePresent(POST_TITLE)
        ;
    }
}
