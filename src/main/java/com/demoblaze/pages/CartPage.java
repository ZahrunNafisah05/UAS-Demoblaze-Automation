package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By addToCartBtn = By.linkText("Add to cart");
    By cartMenu = By.id("cartur");
    By cartRows = By.cssSelector("table#tbodyid tr");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartRows));
        } catch (Exception e) {
            System.out.println("Cart kosong, tidak ada produk.");
        }
    }

    public String getFirstProductName() {
        List<WebElement> rows = driver.findElements(cartRows);
        if (rows.size() > 0) {
            return rows.get(0).findElement(By.xpath("td[2]")).getText();
        }
        return null;
    }

    public void deleteFirstProduct() {
        List<WebElement> rows = driver.findElements(cartRows);
        if (rows.size() > 0) {
            WebElement deleteBtn = rows.get(0).findElement(By.linkText("Delete"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
            wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
            // Tunggu row hilang
            wait.until(ExpectedConditions.stalenessOf(rows.get(0)));
        }
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> rows = driver.findElements(cartRows);
        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("td[2]")).getText();
            if (name.equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public int getCartRowCount() {
        return driver.findElements(cartRows).size();
    }
}
