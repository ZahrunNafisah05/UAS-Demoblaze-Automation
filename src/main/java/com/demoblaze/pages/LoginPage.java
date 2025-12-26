package com.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By loginMenu = By.id("login2");
    By username = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // lebih aman
    }

    public void login(String user, String pass) {
        driver.findElement(loginMenu).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("LOGIN ALERT: " + alert.getText());
            alert.accept();
        } catch (TimeoutException e) {
            // lanjut jika tidak ada alert
        }
    }
}
