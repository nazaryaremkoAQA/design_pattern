package actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

public class HomePageActions extends BasePageActions {

    HomePage page = new HomePage();

    public HomePageActions(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void openPage() {
        openUrl(page.getPageUrl());
        waitForVisibilityOf(page.getPrice(),5);
    }

    public DetailsPageActions clickOnIpad(){
        click(page.getiPadMini());

        return new DetailsPageActions(driver,logger);
    }

    public List<String> getAllProductsName() {

        List<WebElement> elements = driver.findElements(page.getProducts());
        List<String> products = new ArrayList<>();

        for (WebElement el : elements) {
            products.add(el.getText());
        }

        return products;
    }

    public List<String> getAllProductsPrice() {

        List<WebElement> elements = driver.findElements(page.getPrice());
        List<String> prices = new ArrayList<>();

        for (WebElement el : elements) {
            prices.add(el.getText());
        }

        return prices;
    }

}
