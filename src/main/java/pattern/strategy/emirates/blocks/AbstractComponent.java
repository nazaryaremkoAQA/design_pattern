package pattern.strategy.emirates.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DatePicker;

import java.util.Map;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    public abstract boolean isDisplayed();

    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

 }