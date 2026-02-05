package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver setUpDriver(){
        driver = new ChromeDriver(
                new ChromeOptions()
                        .addArguments("--headless=new"));
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
