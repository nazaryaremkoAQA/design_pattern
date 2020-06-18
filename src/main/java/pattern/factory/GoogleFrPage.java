package pattern.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleFrPage extends GooglePage{

    public GoogleFrPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("http://google.fr");
    }

    @Override
    public void search(String keyword) {
        this.searchWidget.enter(keyword);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @Override
    public int getResultsCount() {
        wait.until(d -> results.size() > 1);
        return results.size();
    }
}
