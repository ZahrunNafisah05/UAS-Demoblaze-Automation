package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PurchasePage {

    WebDriver driver;
    WebDriverWait wait;

    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void placeOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys("Nafisah");
        driver.findElement(countryField).sendKeys("Indonesia");
        driver.findElement(cityField).sendKeys("Jakarta");
        driver.findElement(cardField).sendKeys("123456789");
        driver.findElement(monthField).sendKeys("12");
        driver.findElement(yearField).sendKeys("2025");

        driver.findElement(purchaseBtn).click();
    }
    public void placeOrderWithoutData() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(purchaseBtn)).click();
    }

}
