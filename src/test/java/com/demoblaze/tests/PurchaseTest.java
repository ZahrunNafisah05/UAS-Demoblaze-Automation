package com.demoblaze.tests;

import com.demoblaze.pages.*;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class PurchaseTest extends BaseTest {

    @Test
    void testPurchaseFlow() {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        PurchasePage purchase = new PurchasePage(driver);

        login.login("demoblaze", "demoblaze");
        ScreenshotUtil.capture(driver, "01_login_success");

        product.selectProduct();
        ScreenshotUtil.capture(driver, "02_product_page");

        cart.addProductToCart();
        ScreenshotUtil.capture(driver, "03_add_to_cart");

        cart.openCart();
        ScreenshotUtil.capture(driver, "04_cart_page");

        purchase.placeOrder();
        ScreenshotUtil.capture(driver, "05_purchase_success");
    }
}

