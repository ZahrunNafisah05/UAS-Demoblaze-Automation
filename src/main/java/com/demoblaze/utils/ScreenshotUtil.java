package com.demoblaze.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path destDir = Paths.get("src/test/resources/screenshots");

            Files.createDirectories(destDir);

            Path destFile = destDir.resolve(fileName + ".png");

            Files.copy(src.toPath(), destFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
