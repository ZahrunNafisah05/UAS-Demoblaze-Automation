package com.demoblaze.tests;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utils.ScreenshotUtil;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void testLogin() throws InterruptedException {

        LoginPage login = new LoginPage(driver);

        login.login("demoblaze", "demoblaze");

        Thread.sleep(3000);
        ScreenshotUtil.capture(driver, "01_login_success");

        test.pass("Login berhasil menggunakan akun valid");
    }
}
