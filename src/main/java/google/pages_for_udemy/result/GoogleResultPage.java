package google.pages_for_udemy.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import google.pages_for_udemy.common.SearchSuggestion;
import google.pages_for_udemy.common.SearchWidget;

public class GoogleResultPage {

    private SearchSuggestion suggestion;
    private SearchWidget searchWidget;
    private NavigationBar navigationBar;
    private ResultState resultState;

    public GoogleResultPage(final WebDriver driver) {

        this.suggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultState = PageFactory.initElements(driver, ResultState.class);
    }

    public SearchSuggestion getSuggestion() {
        return suggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultState getResultState() {
        return resultState;
    }
}
