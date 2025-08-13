package utils_Layer;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base_layer.Base_Class;

public class JavaScriptExecutor_Utils extends Base_Class {

    private static JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    // Scroll actions
    public static void scrollByPixels(int x, int y) {
        getJSExecutor().executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public static void scrollToBottom() {
        getJSExecutor().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollToTop() {
        getJSExecutor().executeScript("window.scrollTo(0, 0);");
    }

    public static void scrollIntoView(WebElement element) {
        getJSExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Element actions
    public static void clickElement(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public static void setInputValue(WebElement element, String value) {
        getJSExecutor().executeScript("arguments[0].value='" + value + "';", element);
    }

    public static String getInputValue(WebElement element) {
        return (String) getJSExecutor().executeScript("return arguments[0].value;", element);
    }

    public static void highlightElement(WebElement element) {
        getJSExecutor().executeScript("arguments[0].style.border='3px solid red';", element);
    }

    // Page actions
    public static void refreshPage() {
        getJSExecutor().executeScript("history.go(0);");
    }

    public static String getPageTitleByJS() {
        return (String) getJSExecutor().executeScript("return document.title;");
    }

    public static String getInnerText() {
        return (String) getJSExecutor().executeScript("return document.documentElement.innerText;");
    }

    public static void openNewTab(String url) {
        getJSExecutor().executeScript("window.open('" + url + "', '_blank');");
    }

    public static void zoomPage(int zoomPercent) {
        getJSExecutor().executeScript("document.body.style.zoom='" + zoomPercent + "%';");
    }
}
