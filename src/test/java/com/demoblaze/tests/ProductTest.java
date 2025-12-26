package com.demoblaze.tests;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    public void testProductCatalog() {
        test = extent.createTest("Product Catalog Test");

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);

        login.login("demoblaze", "demoblaze");
        ScreenshotUtil.capture(driver, test, "login_page_filled");
        test.pass("Login berhasil");

        home.openProductCategory("Phones");
        ScreenshotUtil.capture(driver, test, "phones_category_opened");
        test.pass("Kategori Phones dibuka");

        product.selectProduct();
        ScreenshotUtil.capture(driver, test, "product_page_filled");
        test.pass("Product berhasil dipilih");
    }

}
