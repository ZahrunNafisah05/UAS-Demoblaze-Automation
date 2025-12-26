package com.demoblaze.tests;

import com.demoblaze.pages.*;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class PurchaseTest extends BaseTest {

    @Test
    void testPurchaseFlow() {
        test = extent.createTest("Purchase Flow Test");

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        PurchasePage purchase = new PurchasePage(driver);

        login.login("demoblaze", "demoblaze");
        ScreenshotUtil.capture(driver, test, "login_page_filled");
        test.pass("Login berhasil");

        product.selectProduct();
        ScreenshotUtil.capture(driver, test, "product_page_filled");
        test.pass("Product dipilih");

        cart.addProductToCart();
        ScreenshotUtil.capture(driver, test, "add_to_cart_success");
        test.pass("Produk berhasil ditambahkan ke cart");

        cart.openCart();
        ScreenshotUtil.capture(driver, test, "cart_page_opened");
        test.pass("Cart dibuka");

        purchase.placeOrder();
        ScreenshotUtil.capture(driver, test, "purchase_completed");
        test.pass("Order berhasil dilakukan");
    }
    @Test
    void testPurchaseWithoutBuyerData() {
        test = extent.createTest("Purchase Flow Test - Without Buyer Data");

        LoginPage login = new LoginPage(driver);
        CartPage cart = new CartPage(driver);
        PurchasePage purchase = new PurchasePage(driver);

        login.login("demoblaze", "demoblaze");
        ScreenshotUtil.capture(driver, test, "login_page_filled");
        test.pass("Login berhasil");

        cart.openCart();
        ScreenshotUtil.capture(driver, test, "cart_page_opened");
        test.pass("Cart dibuka");

        purchase.placeOrderWithoutData();
        ScreenshotUtil.capture(driver, test, "purchase_attempted_without_data");
        test.pass("Order dicoba dilakukan tanpa mengisi data pembeli");
    }

}

