package pattern.strategy.google_app.actions;

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