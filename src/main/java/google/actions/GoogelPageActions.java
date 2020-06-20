package google.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import google.pages_for_my_imp.GooglePage;

import java.util.List;

public class GoogelPageActions extends BasePageActions {

    GooglePage page = new GooglePage();

    public GoogelPageActions(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        openUrl(page.getPageUrl());
        waitForVisibilityOf(page.getGoogle(),10);

    }

    public void typeText(String text) {
        typeText(page.getField(), text);
    }

    public GoogleResultActions clickOnNSuggestion(int n) {

        waitForVisibilityOf(page.getSuggestion(),10);

        List<WebElement> elements = driver.findElements(page.getSuggestion());
        WebElement webElement = elements.get(n);
        System.out.println(webElement.getText());
        webElement.click();

        return new GoogleResultActions(driver, logger);
    }

    public GoogleResultActions clickOnSearh() throws InterruptedException {
//        click(page.getSearchButton());
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(page.getSearchButton()))).click();


        return new GoogleResultActions(driver, logger);
    }
}
