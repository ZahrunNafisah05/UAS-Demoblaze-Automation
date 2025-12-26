package com.demoblaze.tests;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void testLogin() {

        test = extent.createTest("Login Test");

        LoginPage login = new LoginPage(driver);
        login.login("demoblaze", "demoblaze");

        ScreenshotUtil.capture(driver, test, "login_success");

        test.pass("Login berhasil");
    }
    @Test
    void testLoginfail() {

        test = extent.createTest("Login Test Fail");

        LoginPage login = new LoginPage(driver);
        login.login("admin", "admin");

        ScreenshotUtil.capture(driver, test, "login_failed");

        test.pass("Login gagal");
    }
}
