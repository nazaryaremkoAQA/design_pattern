package google.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import google.pages_for_my_imp.GoogleVideoPage;

public class GoogleVideoActions extends BasePageActions {
    GoogleVideoPage page = new GoogleVideoPage();

    public GoogleVideoActions(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public String getResult() {
        waitForVisibilityOf(page.getResult(),10);

        return getText(page.getResult());
    }
}
