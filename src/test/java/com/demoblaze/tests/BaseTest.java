package com.demoblaze.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoblaze.pages.BasePage;
import com.demoblaze.utils.ExtentReportManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static ExtentReports extent; // satu instance untuk semua test class
    protected WebDriver driver;
    protected ExtentTest test;

    @BeforeAll
    static void setupAll() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeEach
    void setup() {
        driver = BasePage.openBrowser();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @AfterAll
    static void tearDownAll() {
        extent.flush(); // flush sekali di akhir semua test
    }
}
