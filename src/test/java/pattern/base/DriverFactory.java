package pattern.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static String browser;

    private DriverFactory(String browser) {
        this.browser = browser;
    }

    public static WebDriver getDriver(String browser) {
        DriverFactory driverFactory = new DriverFactory(browser);
        return driverFactory.createDriver();
    }

    private static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();

    //chrome driver supplier
    private static final Supplier<WebDriver> chromeDriverSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_windows_83.exe");
        return new ChromeDriver();
    };

    //firefox driver supplier
    private static final Supplier<WebDriver> firefoxDriverSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        return new FirefoxDriver();
    };

    //add more suppliers here

    //add all the drivers into a map
    static{
        driverMap.put("chrome_windows_83", chromeDriverSupplier);
        driverMap.put("firefox", firefoxDriverSupplier);
    }

    //return a new driver from the map
    public static final WebDriver createDriver(){
        return driverMap.get(browser).get();
    }
}
