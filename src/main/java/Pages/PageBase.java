package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class PageBase {
    static WebDriver driver;
    public PageBase(WebDriver driver) {
        PageBase.driver = driver;
    }

    protected WebElement find (By locator) {
        return driver.findElement(locator);
    }
    public static WebElement action(By locator) {
        return driver.findElement(locator);
    }


    public static WebElement WebElement(By locator){
        return driver.findElement(locator);
    }
    protected static void waitElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void setText(By locator, String data) {
        waitElement(locator);
        getElement(locator).sendKeys(data);
//        action(locator).isEnabled();
//        action(locator).clear();
//        action(locator).sendKeys(data);
    }

    public static void clicks(By locator) {
        waitElement(locator);
        action(locator).click();
    }

    public static WebElement getElement(By locator) {
        WebElement element = null;
        try {
            element = driver.findElement(locator);
        } catch (Exception e) {
            System.out.print("Some error while locating element" + locator);
            e.printStackTrace();
        }
        return element;
    }

    public static void click(By locator) {
//        try {
            waitElement(locator);
            getElement(locator).click();
//        } catch (Exception e) {
//            System.out.print("Some error while locating element" + locatore);
//            e.printStackTrace();
//        }
    }
    public static void selectDataByIndex(By locator, int index) {
        Select select;
        select = new Select(action(locator));
        select.selectByIndex(index);
    }

    public static void selectDataByValue(By locator, String role) {
        Select select;
        select = new Select(action(locator));
        select.selectByValue(role);
    }

    public static void selectDataByVisibleText(By locator, String role) {
        Select select;
        select = new Select(action(locator));
        select.selectByVisibleText(role);
    }
    public static boolean isDisplayed(By locator) {
        return action(locator).isDisplayed();
    }

    public static String getContent(By locator) {
        waitElement(locator);
        return action(locator).getText();
    }

    public static void scrollToElement() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)", "");
    }

    public static void hover(By locator){
        WebElement ele = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    public void uploadFile(By locator, String photoUrl) throws IOException {
        waitElement(locator);
        action(locator).sendKeys(photoUrl);
        Runtime.getRuntime().exec(photoUrl);
    }

}