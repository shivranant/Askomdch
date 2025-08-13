package utils_Layer;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base_layer.Base_Class;


public class Waits_Utils  extends Base_Class {
	   private static WebDriverWait getWait() {
	        return new WebDriverWait(getDriver(),Duration.ofSeconds(30) );
	    }

	    // 1. Wait for visibility of element
	    public static WebElement waitForVisibility(WebElement element) {
	        return getWait().until(ExpectedConditions.visibilityOf(element));
	    }

	    // 2. Wait for visibility of element located by
	    public static WebElement waitForVisibility(By locator) {
	        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    // 3. Wait for all elements visible
	    public static List<WebElement> waitForAllVisibility(List<WebElement> elements) {
	        return getWait().until(ExpectedConditions.visibilityOfAllElements(elements));
	    }

	    // 4. Wait for element to be clickable
	    public static WebElement waitForClickable(WebElement element) {
	        return getWait().until(ExpectedConditions.elementToBeClickable(element));
	    }

	    // 5. Wait for presence of element
	    public static WebElement waitForPresence(By locator) {
	        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	    // 6. Wait for invisibility of element
	    public static boolean waitForInvisibility(By locator) {
	        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }

	    // 7. Wait for title contains
	    public static boolean waitForTitleContains(String partialTitle) {
	        return getWait().until(ExpectedConditions.titleContains(partialTitle));
	    }

	    // 8. Wait for exact title
	    public static boolean waitForTitleIs(String exactTitle) {
	        return getWait().until(ExpectedConditions.titleIs(exactTitle));
	    }

	    // 9. Wait for URL contains
	    public static boolean waitForUrlContains(String partialUrl) {
	        return getWait().until(ExpectedConditions.urlContains(partialUrl));
	    }

	    // 10. Wait for exact URL
	    public static boolean waitForUrlToBe(String expectedUrl) {
	        return getWait().until(ExpectedConditions.urlToBe(expectedUrl));
	    }

	    // 11. Wait for alert and return it
	    public static Alert waitForAlert() {
	        return getWait().until(ExpectedConditions.alertIsPresent());
	    }

	    // 12. Wait for frame and switch
	    public static void waitForFrameAndSwitchToIt(By locator) {
	        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	    }

	    public static void waitForFrameAndSwitchToIt(int index) {
	        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	    }

	    public static void waitForFrameAndSwitchToIt(String nameOrId) {
	        getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	    }

	    // 13. Wait for text to be present in element
	    public static boolean waitForTextInElement(WebElement element, String text) {
	        return getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
	    }

	    // 14. Wait for text to be present in element located
	    public static boolean waitForTextInElement(By locator, String text) {
	        return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	    }

	    // 15. Wait for element attribute to contain value
	    public static boolean waitForAttributeToContain(WebElement element, String attribute, String value) {
	        return getWait().until(ExpectedConditions.attributeContains(element, attribute, value));
	    }

	    // 16. Wait for element attribute to be exactly
	    public static boolean waitForAttributeToBe(WebElement element, String attribute, String value) {
	        return getWait().until(ExpectedConditions.attributeToBe(element, attribute, value));
	    }

	    // 17. Wait for element selection state
	    public static boolean waitForElementToBeSelected(WebElement element) {
	        return getWait().until(ExpectedConditions.elementToBeSelected(element));
	    }

	    public static boolean waitForElementSelectionState(WebElement element, boolean selected) {
	        return getWait().until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	    }

	    // 18. Wait for JavaScript ready state
//	    public static void waitForPageToLoadCompletely() {
//	        new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(
//	            driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//	    }

	    // 19. Custom timeout and polling (optional advanced)
	    public static WebElement waitWithCustomTimeout(By locator, int timeoutSeconds, int pollingMillis) {
	        WebDriverWait customWait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds));
	        customWait.pollingEvery(Duration.ofMillis(pollingMillis));
	        customWait.ignoring(NoSuchElementException.class);
	        return customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

}
