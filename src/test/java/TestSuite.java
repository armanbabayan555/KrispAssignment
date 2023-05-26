import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageobjects.screens.KrispAccountScreen;
import pageobjects.screens.KrispLoginScreen;

import static messages.Messages.*;

public class TestSuite extends BaseTest {

    @Test(description = "Checking the functionality of logging in, clicking on What's New, and logging out.")
    public void krispTest() {
        final String email = "armanbabayan2001@gmail.com";
        KrispLoginScreen krispLoginScreen = new KrispLoginScreen();
        SoftAssert softAssert = new SoftAssert();

        krispLoginScreen.clickAndTypeIntoEmailBox(email);
        KrispAccountScreen krispAccountScreen = krispLoginScreen.clickSignInButton();
        // Verification goes here
        krispAccountScreen.clickOnUserInfoButton();
        softAssert.assertEquals(krispAccountScreen.getEmail(), email, WRONG_EMAIL);

        krispAccountScreen
                .clickSideBarButtonByIndex(0)
                .clickHelpButton()
                .clickWhatsNewButton()
                .switchToTab(1);

        softAssert.assertEquals(krispAccountScreen.getLink(), "https://whatsnew.krisp.ai/", WHATS_NEW_DIDNT_OPEN);
        krispAccountScreen.switchToTab(0);
        krispAccountScreen
                .clickSideBarButtonByIndex(1)
                .clickOnUserInfoButton()
                .clickSignOutButton();

        softAssert.assertTrue(krispLoginScreen.isEmailBoxPresent(), LOGOUT_DIDNT_WORK);
        softAssert.assertAll();
    }
}
