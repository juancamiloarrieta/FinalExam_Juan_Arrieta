package disableUserTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

import java.util.logging.Logger;

public class DisableUserTest {

    Logger logger = Logger.getLogger(this.getClass().getName());
    MainPage mainPage;

    @BeforeMethod
    @Parameters({"URL"})
    public void searchPage(String url) {
        mainPage = new MainPage(url);
    }

    @Parameters({"username", "password"})
    @Test
    public void LogIn(String username, String password) {
        mainPage.logIn(username, password);
        mainPage.disableUser();
    }

    @AfterTest
    @Parameters({"browser"})
    public void closeBrowser(String browser) {
        mainPage.closeBrowser();
    }

}
