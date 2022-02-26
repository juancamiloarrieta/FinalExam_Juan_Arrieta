package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    String url;

    public BasePage(String url) {
        this.url = url;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(this.url);
    }

    public void click(By selector){
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(selector)).click();
    }

    public void implicitWait(Long time, TimeUnit timeUnit){
        driver.manage().timeouts().implicitlyWait(time, timeUnit);
    }

    public void implicitWait(Long time){
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void switchIFrame(String iFrameId){
        driver.switchTo().frame(iFrameId);
    }

    public void setDefaultIFrame(){
        driver.switchTo().defaultContent();
    }

    public void sendKeysTo(WebElement webElement, String keys){
        webElement.sendKeys(keys);
    }

    public void closeBrowser(){
        driver.close();
    }

}
