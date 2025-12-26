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

            String projectDir = System.getProperty("user.dir");
            String dir = projectDir + "/src/test/resources/screenshots";
            Files.createDirectories(Paths.get(dir));

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String path = dir + "/" + stepName + "_" + timestamp + ".png";

            Files.copy(src.toPath(), Paths.get(path));

            test.addScreenCaptureFromPath(path);
            System.out.println("Screenshot tersimpan di: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
