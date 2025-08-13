package utils_Layer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base_layer.Base_Class;

public class Screenshot_Utils  extends Base_Class{
    // Capture screenshot with a custom name and return the path
    public static String captureScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
        String path = screenshotDir + screenshotName + "_" + timestamp + ".png";
        File destFile = new File(path);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

}
