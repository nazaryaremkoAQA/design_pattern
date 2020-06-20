package google.pages_for_udemy.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import google.pages_for_udemy.common.AbstractComponent;

public class ResultState extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stat;

    public ResultState(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(d -> this.stat.isDisplayed());
    }

    public String getStat() {
        return this.stat.getText();
    }
}
