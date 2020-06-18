package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserDriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private String browser;

    private Logger log;

    private BrowserDriverFactory(String browser, Logger log) {
        this.browser = browser;
        this.log = log;
    }

    public static WebDriver getDriver(String browser, Logger log) {
        BrowserDriverFactory driverFactory = new BrowserDriverFactory(browser, log);
        return driverFactory.createDriver();
    }

    private ChromeOptions getChrome_options(){
        ChromeOptions chrome_options = new ChromeOptions();
//        chrome_options.addArguments("--headless");
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--disable-dev-shm-usage");
        return chrome_options;
    }

    private FirefoxOptions getFirefox_options(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
        return firefoxOptions;
    }

    private WebDriver createDriver() {
        log.info("Create drive: " + browser);

        switch (browser) {

            case "chrome_windows_83":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_windows_83.exe");
                driver.set(new ChromeDriver(getChrome_options()));
                break;

            case "geckodriver":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver.set(new FirefoxDriver(getFirefox_options()));
                break;

            case "chrome_linux_83":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_linux_83");
                driver.set(new ChromeDriver(getChrome_options()));
                break;

            case "chrome_linux_84":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_linux_84");
                driver.set(new ChromeDriver(getChrome_options()));
                break;

            case "chrome_mac_83":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_mac_83");
                driver.set(new ChromeDriver(getChrome_options()));
                break;

            case "chrome_mac_84":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_mac_84");
                driver.set(new ChromeDriver(getChrome_options()));
                break;

            default:
                log.info("Do not know how to start: " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome_windows_83.exe");
                driver.set(new ChromeDriver(getChrome_options()));
                break;
        }
        return driver.get();
    }
}
