package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    private By userButton = By.cssSelector("li.user a#global-user-trigger");
    private By logInButton = By.cssSelector("a[tref=\"/members/v3_1/login\"]");
    private WebDriverWait wait = new WebDriverWait(driver,20);


    public void logIn(String username, String password) {
        click(userButton);
        implicitWait(2L);
        click(logInButton);
        implicitWait(2L);
        switchIFrame("disneyid-iframe");
        WebElement usernameInput = driver.findElement(By.cssSelector("input[placeholder*=\"Username\"]"));
        sendKeysTo(usernameInput, username);
        WebElement passwordInput = driver.findElement(By.cssSelector("input[placeholder*=\"Password\"]"));
        sendKeysTo(passwordInput, password);
        WebElement logInIFrameButton = driver.findElement(By.cssSelector("button[aria-label*=\"Log In\"]"));
        logInIFrameButton.click();
        setDefaultIFrame();
    }

    public void logOut(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(userButton);
        implicitWait(2L);
        WebElement logOutButton = driver.findElement(By.cssSelector("li.user a[onclick=\"javascript:espn.memberservices.logout();return false;\"]"));
        logOutButton.click();
    }

    public void disableUser(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(userButton);
        implicitWait(2L);
        WebElement espnProfile = driver.findElement(By.cssSelector("li.user a[tref=\"/members/v3_1/modifyAccount\"]"));
        espnProfile.click();
        switchIFrame("disneyid-iframe");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement deleteAccountButton = driver.findElement(By.cssSelector("a#cancel-account"));
        deleteAccountButton.click();
    }

    public MainPage(String url) {
        super(url);
    }

    public Boolean isLoggedIn(){
        try{
            WebElement logOutButton = driver.findElement(By.cssSelector("li.user a[onclick=\"javascript:espn.memberservices.logout();return false;\"]"));
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
