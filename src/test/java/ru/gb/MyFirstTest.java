package ru.gb;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.URL;

public class MyFirstTest {
    @Test
    public void CheckEmptyEmail() throws Exception {
        // Устанавливаем capabilities.
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel2");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
//      Проверьте актуальность пути до приложения на своём компьютере.
        capabilities.setCapability("app",
                "/Users/starshev.dmitriy/Downloads/Android-NativeDemoApp-0.2.1.apk");
//      Устанавливаем и открываем приложение.
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//      Нажимаем Login в меню
        Thread.sleep(5000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);
//      Нажимаем Login на странице логин/пароль.
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);
//      Проверяем текст ошибки.
        MobileElement errorText = (MobileElement) driver.findElementByXPath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view." +
                        "ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        Assert.assertEquals(errorText.getText(), "Please enter a valid email address");
    }
    @Test
    public void NegativeAuthorization() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel2");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app",
                "/Users/starshev.dmitriy/Downloads/Android-NativeDemoApp-0.2.1.apk");
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);
        MobileElement imputEmail = (MobileElement) driver.findElementByAccessibilityId("input-email");
        imputEmail.click();
        imputEmail.sendKeys("test@mail.ru");
        Thread.sleep(2000);
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(2000);
        MobileElement errorText = (MobileElement) driver.findElementByXPath(
                "//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android." +
                        "view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView");
        Assert.assertEquals(errorText.getText(), "Please enter at least 8 characters");
    }
    @Test
    public void PositiveAuthorization() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel2");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app",
                "/Users/starshev.dmitriy/Downloads/Android-NativeDemoApp-0.2.1.apk");
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(5000);
        MobileElement loginMenuButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        loginMenuButton.click();
        Thread.sleep(2000);
        MobileElement imputEmail = (MobileElement) driver.findElementByAccessibilityId("input-email");
        imputEmail.click();
        imputEmail.sendKeys("test@mail.ru");
        Thread.sleep(2000);
        MobileElement imputPassword = (MobileElement) driver.findElementByAccessibilityId("input-password");
        imputPassword.click();
        imputPassword.sendKeys("12345678");
        Thread.sleep(2000);
        MobileElement loginButton = (MobileElement) driver.findElementByAccessibilityId("button-LOGIN");
        loginButton.click();
        Thread.sleep(4000);
        MobileElement successText = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget." +
                        "FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget." +
                        "LinearLayout/android.widget.TextView");
        Assert.assertEquals(successText.getText(), "Success");
    }
}
