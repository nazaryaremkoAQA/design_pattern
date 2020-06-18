package pages;

import org.openqa.selenium.By;

public class GoogleResultPage {

    private By result = By.xpath("//h3/../../../div[@class='r']");
    private By field = By.xpath("//input[@name='q']");
    private By suggestion = By.xpath("//div[@class='sbtc']//ancestor::span");
    private By videoButton = By.xpath("//div[@class='hdtb-mitem hdtb-msel hdtb-imb']/span");


    public By getResult() {
        return result;
    }

    public By getField() {
        return field;
    }

    public By getSuggestion() {
        return suggestion;
    }

    public By getVideoButton() {
        return videoButton;
    }
}
