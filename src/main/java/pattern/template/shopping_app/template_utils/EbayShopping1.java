package pattern.template.shopping_app.template_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pattern.template.shopping_app.pages.EbayHomePage;
import pattern.template.shopping_app.pages.EbayProductDescriptionPage;
import pattern.template.shopping_app.pages.EbayResultPage;

public class EbayShopping1 extends ShoppingTemplate {

    private EbayHomePage ebayHomePage;
    private EbayResultPage ebayResultPage;
    private EbayProductDescriptionPage productDescriptionPage;

    public EbayShopping1(WebDriver driver, String product) {
        this.ebayHomePage = new EbayHomePage(driver, product);
        this.ebayResultPage = new EbayResultPage(driver);
        this.productDescriptionPage = new EbayProductDescriptionPage(driver);
        this.ebayHomePage.setWait(new WebDriverWait(driver, 30));
        this.ebayResultPage.wait = new WebDriverWait(driver, 30);
        this.productDescriptionPage.wait = new WebDriverWait(driver, 30);
    }

    @Override
    public void launchSite() {
        this.ebayHomePage.getDriver().get("https://www.ebay.com/");
    }

    @Override
    public void searchItem() {
        this.ebayHomePage.getSearchBlock().getWait().until(i -> ebayHomePage.getSearchBlock().getSearchBox().isDisplayed());
        this.ebayHomePage.getSearchBlock().getSearchBox().sendKeys(ebayHomePage.getProduct());
        this.ebayHomePage.getSearchBlock().getSearchButton().click();
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
