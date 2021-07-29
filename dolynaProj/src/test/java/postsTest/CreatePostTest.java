package postsTest;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class CreatePostTest extends BaseTest {
    final String POST_TITLE = "Halyna title of Post"+ Util.getDateAndTimeFormatted();
    @Test
    public void createPost(){
        loginPage
                .loginWithValidCread()
                .checkIsButtonSignOutVisible()
                .clickOnButtonCreatePost()
                .checkIsInputTitlePresent()
                .enterTextIntoInputTitle(POST_TITLE)
                .enterTextIntoInputBody("Body text")
                .clickOnSaveButton()
                ;


    }

}