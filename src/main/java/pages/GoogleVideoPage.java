package pages;

import org.openqa.selenium.By;

public class GoogleVideoPage {

    private By result = By.xpath("//div[@id='result-stats']");

    public By getResult() {
        return result;
    }
}
