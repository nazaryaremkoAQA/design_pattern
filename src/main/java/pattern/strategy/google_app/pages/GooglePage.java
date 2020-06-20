package pattern.strategy.google_app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pattern.strategy.google_app.actions.ISearchStrategy;


public class GooglePage {

    private WebDriver driver;
    private ISearchStrategy strategy;
    private By result = By.className("rc");

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String txt) throws InterruptedException {
        this.strategy.search(txt);
    }

    public void setStrategy(ISearchStrategy strategy) {
        this.strategy = strategy;
        PageFactory.initElements(driver, this.strategy);
    }

    public int getResultsCount() {
        return this.driver.findElements(result).size();
    }

    public void goTo() {
        driver.get("https://www.google.com");
    }
}