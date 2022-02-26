package logInTest;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.MainPage;

import java.util.logging.Logger;

@Test
public class LogInTest {

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
        Assert.assertEquals(mainPage.isLoggedIn(),Boolean.TRUE);
    }

    @AfterTest
    @Parameters({"browser"})
    public void closeBrowser(String browser) {
        mainPage.closeBrowser();
    }
}
