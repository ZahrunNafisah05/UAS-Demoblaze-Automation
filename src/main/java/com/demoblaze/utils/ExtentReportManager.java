package com.demoblaze.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {

            String reportPath = "src/test/resources/report/extent-report.html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(new File(reportPath));

            sparkReporter.config().setReportName("UAS Automation Testing Report");
            sparkReporter.config().setDocumentTitle("Demoblaze Automation Result");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Zahrun Nafisah");
            extent.setSystemInfo("Website", "https://www.demoblaze.com");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
