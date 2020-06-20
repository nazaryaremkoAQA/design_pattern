package google.pages_for_udemy.result;

import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import google.pages_for_udemy.common.AbstractComponent;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(xpath = "(//span/ancestor::a[@class='q qs'])[1]")
    private WebElement images;

    @FindBy(xpath = "(//span/ancestor::a[@class='q qs'])[2]")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages(){
        this.images.click();
    }

    public void goToNews(){
        this.news.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((Function<? super WebDriver, Boolean>) d-> this.bar.isDisplayed());
    }
}
