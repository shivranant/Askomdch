package Base_layer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {
	
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void initialization() {
        tlDriver.set(new FirefoxDriver());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get("https://automationexercise.com/");
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            tlDriver.remove();  // clean up ThreadLocal
        }
    }

}
