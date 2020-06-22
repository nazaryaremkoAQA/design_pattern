package pattern.template.shopping_app.template_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pattern.template.shopping_app.pages.EbayProductDescriptionPage;
import pattern.template.shopping_app.pages.EbayResultPage;
import pattern.template.shopping_app.pages.EbaySearchPage;

public class EbayShopping extends ShoppingTemplate {

    private EbaySearchPage ebaySearchPage;
    private EbayResultPage ebayResultPage;
    private EbayProductDescriptionPage productDescriptionPage;

    public EbayShopping(WebDriver driver, String product) {
        this.ebaySearchPage = new EbaySearchPage(driver, product);
        this.ebayResultPage = new EbayResultPage(driver);
        this.productDescriptionPage = new EbayProductDescriptionPage(driver);
        this.ebaySearchPage.setWait(new WebDriverWait(driver, 30));
        this.ebayResultPage.wait = new WebDriverWait(driver, 30);
        this.productDescriptionPage.wait = new WebDriverWait(driver, 30);
    }

    @Override
    public void launchSite() {
        this.ebaySearchPage.getDriver().get("https://www.ebay.com/");
    }

    @Override
    public void searchItem() {
        this.ebaySearchPage.getWait().until(i -> ebaySearchPage.getSearchBox().isDisplayed());
        this.ebaySearchPage.getSearchBox().sendKeys(ebaySearchPage.getProduct());
        this.ebaySearchPage.getSearchButton().click();
    }

    @Override
    public void selectProduct() {
        this.ebayResultPage.getWait().until(i -> ebayResultPage.getItem().isDisplayed());
        this.ebayResultPage.getItem().click();
    }

    @Override
    public String buy() {
        this.productDescriptionPage.getWait().until(i -> productDescriptionPage.getPrice().isDisplayed());
        return productDescriptionPage.getPrice().getText();
    }
}
