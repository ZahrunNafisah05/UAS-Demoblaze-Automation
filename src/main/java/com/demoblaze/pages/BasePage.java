package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver openBrowser() {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1366, 768));

        driver.get("https://www.demoblaze.com");
        return driver;
    }
}
