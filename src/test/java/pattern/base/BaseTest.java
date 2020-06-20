package pattern.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

public class BaseTest {

    protected Utils utils = new Utils();
    protected WebDriver driver = DriverFactory.getDriver(utils.getProperty("browser"));

    @BeforeTest
    public void setUpDriver() {
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
