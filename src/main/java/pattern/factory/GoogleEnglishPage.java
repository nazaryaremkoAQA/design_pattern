package pattern.factory;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleEnglishPage extends GooglePage {


    public GoogleEnglishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("http://google.com");
    }

    @Override
    public void search(String keyword) {
        this.searchWidget.enter(keyword);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @Override
    public int getResultsCount() {
        wait.until((Function<? super WebDriver, Boolean>) d -> results.size() > 1);
        return results.size();
    }


}