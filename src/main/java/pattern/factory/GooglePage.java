package pattern.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import google.pages_for_udemy.common.SearchWidget;
import google.pages_for_udemy.result.ResultState;

import java.util.List;

public abstract class GooglePage {

    @FindBy(xpath = "//div[@class='rc']")
    protected List<WebElement> results;

    @FindBy(xpath = "//img[contains(@id,'balloon')]")
    protected WebElement img;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SearchWidget searchWidget;
    protected ResultState resultState;

    public abstract void launchSite();
    public abstract void search(String keyword);
    public abstract int getResultsCount();


    public GooglePage(final WebDriver driver){
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.resultState = PageFactory.initElements(driver, ResultState.class);
        this.wait = new WebDriverWait(driver, 30);
        this.driver = driver;

     }
}
