package commons;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Print extends DriverManager {
    public static void takeScreenShot(TestInfo info) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            File directory = new File("./evidence");
            if (!directory.exists()) {
                directory.mkdir();
            }

            String filePath = String.format("./evidence/%s.png", info.getDisplayName());

            FileUtils.copyFile(scrFile, new File(filePath));

            System.out.println("Screenshot saved: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] screenShot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}