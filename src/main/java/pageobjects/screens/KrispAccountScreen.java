package pageobjects.screens;

import locators.KrispAccountScreenLocators;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;
import setup.WaitUtils;

public class KrispAccountScreen extends BaseScreen {

    private final By userInfoButton = By.xpath(KrispAccountScreenLocators.USER_INFO_BUTTON);
    private final By email = By.xpath(KrispAccountScreenLocators.EMAIL);
    private final By helpButton = By.xpath(KrispAccountScreenLocators.HELP_BUTTON);
    private final By whatsNewButton = By.linkText(KrispAccountScreenLocators.WHATS_NEW_BUTTON);
    private final By signOutButton = By.xpath(KrispAccountScreenLocators.SIGN_OUT_BUTTON);

    private final By sidebarButtons = By.xpath(KrispAccountScreenLocators.SIDEBAR_BUTTONS);

    public KrispAccountScreen clickOnUserInfoButton() {
        WaitUtils.getInstance().longWaitForElementToBeClickable(userInfoButton); // Long wait added for passing the verification
        click(userInfoButton);
        return this;
    }

    public KrispAccountScreen clickHelpButton() {
        click(helpButton);
        return this;
    }

    public KrispAccountScreen clickWhatsNewButton() {
        click(whatsNewButton);
        return this;
    }

    public KrispAccountScreen clickSignOutButton() {
        click(signOutButton);
        return this;
    }

    public String getEmail() {
        return getText(email);
    }

    public KrispAccountScreen clickSideBarButtonByIndex(int index) {
        click(sidebarButtons, index);
        return this;
    }

}
