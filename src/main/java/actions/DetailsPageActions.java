package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.DetailsPage;


public class DetailsPageActions extends BasePageActions {

    DetailsPage detailsPage = new DetailsPage();

    public DetailsPageActions(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public int getInStockItem() {
        waitForVisibilityOf(detailsPage.getInStock(), 10);
        String stock = driver.findElement(detailsPage.getInStock()).getText();
        return getIntFromString(stock);
    }

    public int getCartItem() {
        waitForVisibilityOf(detailsPage.getCartItem(), 10);
        String cart = driver.findElement(detailsPage.getCartItem()).getText();
        return getIntFromString(cart);
    }

    public DetailsPageActions clickOnAddToCart() {
        click(detailsPage.getAddToCart());
        return new DetailsPageActions(driver,logger);
    }

    public String getAddCartName() {
        return driver.findElement(detailsPage.getAddToCart()).getText();
    }

}
