package Base_layer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base_Class {
	
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void initialization() throws IOException {
        tlDriver.set(new FirefoxDriver());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\Asus\\Desktop\\Shivkrishna\\Integrated_framewrok\\src\\main\\java\\Configuration_Layer\\Config.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL =p.getProperty("URL");
		getDriver().get(URL);
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            tlDriver.remove();  // clean up ThreadLocal
        }
    }

}
