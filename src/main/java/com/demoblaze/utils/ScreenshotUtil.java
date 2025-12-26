package com.demoblaze.utils;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, ExtentTest test, String stepName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String dir = "target/screenshots";
            Files.createDirectories(Paths.get(dir));

            // Format timestamp: yyyyMMdd_HHmmss
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Gabungkan stepName + timestamp
            String path = dir + "/" + stepName + "_" + timestamp + ".png";

            Files.copy(src.toPath(), Paths.get(path));

            test.addScreenCaptureFromPath(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
