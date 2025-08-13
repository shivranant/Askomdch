package utils_Layer;

import org.openqa.selenium.Alert;

import Base_layer.Base_Class;

public class Alert_Utils extends Base_Class {

    public static Alert switchToAlert() {
        return getDriver().switchTo().alert();
    }

    public static void acceptAlert() {
        switchToAlert().accept();
    }

    public static void dismissAlert() {
        switchToAlert().dismiss();
    }

    public static String getAlertText() {
        return switchToAlert().getText();
    }

    public static void sendTextToAlert(String text) {
        switchToAlert().sendKeys(text);
    }

    public static void acceptAlertIfPresent() {
        try {
            getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No alert present to accept.");
        }
    }

    public static void dismissAlertIfPresent() {
        try {
            getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("No alert present to dismiss.");
        }
    }

    public static String getAlertTextIfPresent() {
        try {
            return getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            System.out.println("No alert present.");
            return null;
        }
    }
}
