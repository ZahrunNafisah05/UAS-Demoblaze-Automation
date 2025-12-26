package com.demoblaze.tests;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testProductCatalog() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        login.login("demoblaze", "demoblaze");
        test.pass("Login berhasil");

        home.openProductCategory("Phones");
        product.selectProduct();

        ScreenshotUtil.capture(driver, "02_product_catalog");
        test.pass("Product berhasil dibuka");
    }


}
