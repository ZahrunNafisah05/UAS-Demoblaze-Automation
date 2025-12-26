package com.demoblaze.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoblaze.utils.ExtentReportManager;
import com.demoblaze.pages.BasePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeEach
    void setup() {
        driver = BasePage.openBrowser();
        extent = ExtentReportManager.getInstance();
    }

    @AfterEach
    void tearDown() {
        extent.flush();
        driver.quit();
    }
}
