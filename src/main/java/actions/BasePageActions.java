package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePageActions {

    protected WebDriver driver;
    protected Logger logger;

    public BasePageActions(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).click();
    }

    protected void typeText(By locator, String text) {
        waitForVisibilityOf(locator, 5);
        find(locator).clear() ;
        find(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        waitForVisibilityOf(locator, 5);
        return find(locator).getText();
    }


    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOut) {
        timeOut = timeOut != null ? timeOut : 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);
    }

    public int getIntFromString(String str){

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return Integer.parseInt(m.group(0));
        }

        return -999999;
    }

    public String getCurrentPage() {
        return driver.getCurrentUrl();
    }

    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attemps = 0;
        while (attemps < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            }catch (StaleElementReferenceException e){

            }
            attemps++;
        }
    }
}
