package pattern.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;

    private DriverFactory(String browser) {
        this.browser = browser;
    }

    public static WebDriver getDriver(String browser) {
        DriverFactory driverFactory = new DriverFactory(browser);
        return driverFactory.createDriver();
    }

    private WebDriver createDriver() {
        switch (browser) {
            case "chrome_windows_83":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_windows_83.exe");
                driver.set(new ChromeDriver());

                break;

            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_windows_83.exe");
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();

    }
}
