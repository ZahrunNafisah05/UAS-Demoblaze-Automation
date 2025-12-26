package com.demoblaze.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.demoblaze.utils.ExtentReportManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;


public class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeEach
    public void setUp() {

        extent = ExtentReportManager.getExtent();
        test = extent.createTest(this.getClass().getSimpleName());

        driver = new ChromeDriver();

        driver.manage().window().setSize(new Dimension(1366, 768));

        driver.get("https://www.demoblaze.com");
    }

    @AfterEach
    public void tearDown() {
        extent.flush();   // WAJIB agar HTML tersimpan
        driver.quit();
    }
}
