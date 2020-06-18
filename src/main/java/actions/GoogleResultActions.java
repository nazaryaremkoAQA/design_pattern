package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.GoogleResultPage;

import java.util.List;

public class GoogleResultActions extends BasePageActions {

    GoogleResultPage page = new GoogleResultPage();

    public GoogleResultActions(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void typeText(String text) {
        typeText(page.getField(), text);
    }


    public GoogleResultActions clickOnNItem(int n) {

        List<WebElement> elements = driver.findElements(page.getResult());
        elements.get(n).click();

        return new GoogleResultActions(driver, logger);

    }

    public GoogleResultActions clickOnNSuggestion(int n){

        waitForVisibilityOf(page.getSuggestion(),10);

        List<WebElement> elements = driver.findElements(page.getSuggestion());
        elements.get(n).click();

        return new GoogleResultActions(driver,logger);
    }

    public GoogleVideoActions clickOnVideo(){
        click(page.getVideoButton());
        return new GoogleVideoActions(driver,logger);
    }



}
