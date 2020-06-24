package pattern.strategy.payment_app.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    public abstract boolean isDisplayed();

    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }
}