package google.pages_for_my_imp;

import org.openqa.selenium.By;

public class GooglePage {

    private String pageUrl = "http://google.com";
    private By field = By.xpath("//input[@name='q']");
    private By searchButton = By.xpath("//input[@name='btnK']");
    private By suggestion = By.xpath("//div[@class='sbtc']//ancestor::span");
    private By google = By.xpath("//input[@name='q']");

    public String getPageUrl() {
        return pageUrl;
    }

    public By getField() {
        return field;
    }

    public By getSearchButton() {
        return searchButton;
    }

    public By getSuggestion() {
        return suggestion;
    }

    public By getGoogle() {
        return google;
    }
}
