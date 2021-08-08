package postsTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePost extends BaseTest {
    final String POST_TITLE = "Chupryna title of post " + Util.getDateAndTimeFormatted();

    @Test
    public void createPost() {
        loginPage
                .loginWithValidCredentials()
                .checkIsButtonSignOutVisible()
                .clickOnButtonCreatePost()
                .checkIsRedirectedOnCreatePostPage()
                .checkIsInputTitlePresent()
                .enterTextIntoPostTitleInput(POST_TITLE)
                .enterTextIntoPostBodyInput("Body text")
                .clickOnButtonSavePost()
                .checkIsButtonDeletePresent()
                .checkIsSuccessMessagePresent()
                .checkTextInSuccessMessage("New post successfully created.")
                .clickOnButtonProfile()
                .checkIsPostWasAdded(POST_TITLE)
        ;
    }
}
