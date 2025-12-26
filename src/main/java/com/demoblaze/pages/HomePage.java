package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By phonesCategory = By.linkText("Phones");
    By laptopsCategory = By.linkText("Laptops");
    By monitorsCategory = By.linkText("Monitors");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openProductCategory(String category) {
        if (category.equalsIgnoreCase("Phones")) {
            driver.findElement(phonesCategory).click();
        } else if (category.equalsIgnoreCase("Laptops")) {
            driver.findElement(laptopsCategory).click();
        } else if (category.equalsIgnoreCase("Monitors")) {
            driver.findElement(monitorsCategory).click();
        }
    }
}
