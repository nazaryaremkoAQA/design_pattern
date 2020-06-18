package pattern.page.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pattern.page.common.SearchSuggestion;
import pattern.page.common.SearchWidget;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget widget;
    private SearchSuggestion suggestion;

    public GoogleMainPage(final WebDriver driver){
        this.driver = driver;
        this.widget = PageFactory.initElements(driver, SearchWidget.class);
        this.suggestion = PageFactory.initElements(driver, SearchSuggestion.class);
    }

    public void goTo(){
        this.driver.get("http://google.com");
    }

    public SearchWidget getWidget() {
        return widget;
    }

    public SearchSuggestion getSuggestion() {
        return suggestion;
    }
}
