package utils_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_layer.Base_Class;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class Action_Utils extends Base_Class {

    private static Actions getActions() {
        return new Actions(getDriver());
    }

    // Mouse Actions
	/*
	 * public static void click(WebElement element) { try {
	 * getActions().moveToElement(element).click().perform(); } catch (Exception e)
	 * { ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",
	 * element); } }
	 */
    public static void hoverOverElement(WebElement element) {
        getActions().moveToElement(element).perform();
    }

    public static void rightClick(WebElement element) {
        getActions().contextClick(element).perform();
    }

    public static void doubleClick(WebElement element) {
        getActions().doubleClick(element).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) {
        getActions().dragAndDrop(source, target).perform();
    }

    public static void clickAndHold(WebElement element) {
        getActions().clickAndHold(element).perform();
    }

    public static void release(WebElement element) {
        getActions().release(element).perform();
    }

    public static void moveByOffset(int x, int y) {
        getActions().moveByOffset(x, y).click().perform();
    }

    // Keyboard Actions
    public static void pressKey(Keys key) {
        getActions().sendKeys(key).perform();
    }

    public static void pressKeyOnElement(WebElement element, Keys key) {
        getActions().sendKeys(element, key).perform();
    }

    public static void typeInCaps(WebElement element, String text) {
        getActions().moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys(text).keyUp(Keys.SHIFT).perform();
    }

    public static void clearAndType(WebElement element, String text) {
        getActions().moveToElement(element).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.BACK_SPACE).sendKeys(text).perform();
    }

    public static void loginUsingActions(WebElement usernameField, WebElement passwordField, String username, String password) {
        getActions().click(usernameField).sendKeys(username).sendKeys(Keys.TAB).sendKeys(password).sendKeys(Keys.ENTER).perform();
    }
    public static void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }
    
    public static void click(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            getActions().moveToElement(element).click().perform();
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
        }
    }
    
    public static void sendKeys(WebElement element, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='" + value + "';", element);
        }
    }
    
    public static boolean isElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



}
