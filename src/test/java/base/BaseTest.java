package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverUtils;

public abstract class BaseTest {
    @BeforeMethod
    public void startDriver() {
        DriverUtils.setDriver();
        DriverUtils.getDriver().get("https://account.krisp.ai/login");
    }

    @AfterMethod
    protected static void tearDown() {
        DriverUtils.quitDriver();
    }
}
