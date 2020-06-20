package pattern.strategy.google_app.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TextStrategy extends AbstractComponent implements ISearchStrategy {

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@name='btnK']")
    private WebElement searchButton;

    public TextStrategy(WebDriver driver) {
        super(driver);
    }

    public void search(String searchFor) throws InterruptedException {
        wait.until(d-> this.searchBox.isDisplayed());
        searchBox.sendKeys(searchFor);
        searchBox.sendKeys(Keys.RETURN);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
