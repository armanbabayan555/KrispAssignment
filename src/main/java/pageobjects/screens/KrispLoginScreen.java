package pageobjects.screens;
import locators.KrispLoginScreenLocators;
import org.openqa.selenium.By;
import pageobjects.base.BaseScreen;

public class KrispLoginScreen extends BaseScreen {

    private final By emailBox = By.id(KrispLoginScreenLocators.EMAIL);
    private final By signInButton = By.xpath(KrispLoginScreenLocators.SIGN_IN);

    public KrispAccountScreen clickSignInButton() {
        click(signInButton);
        return new KrispAccountScreen();
    }
    public KrispLoginScreen clickAndTypeIntoEmailBox(String text) {
        typeTextInField(emailBox, text);
        return this;
    }

    public boolean isEmailBoxPresent() {
        return isElementPresent(emailBox);
    }

}
