package com.demoblaze.tests;

import com.demoblaze.pages.*;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    void testShoppingCart() {

        // Membuat ExtentTest untuk laporan
        test = extent.createTest("Shopping Cart Test");

        // Inisialisasi halaman
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        // Step 1: Login
        login.login("demoblaze", "demoblaze");
        ScreenshotUtil.capture(driver, test, "login_page_filled");
        test.pass("Login berhasil");

        // Step 2: Pilih produk
        product.selectProduct();
        ScreenshotUtil.capture(driver, test, "product_page_filled");
        test.pass("Produk berhasil dipilih");

        // Step 3: Tambah produk ke cart
        cart.addProductToCart();
        ScreenshotUtil.capture(driver, test, "add_to_cart_success");
        test.pass("Produk berhasil ditambahkan ke cart");

        // Step 4: Buka halaman cart
        cart.openCart();
        ScreenshotUtil.capture(driver, test, "cart_page_opened");
        test.pass("Halaman cart berhasil dibuka");
    }
}
