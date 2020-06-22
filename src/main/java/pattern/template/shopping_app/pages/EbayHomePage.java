package pattern.template.shopping_app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pattern.template.shopping_app.blocks.EbaySearchBlock;

public class EbayHomePage extends BasePage {

    private EbaySearchBlock searchBlock;
    private String product;

    public EbayHomePage(final WebDriver driver, String product) {
        super(driver);
        this.product = product;
        this.searchBlock = new EbaySearchBlock(driver);
        this.setWait(  new WebDriverWait(driver, 15));
        PageFactory.initElements(driver, this);
    }

    public String getProduct() {
        return product;
    }


    public EbaySearchBlock getSearchBlock() {
        return searchBlock;
    }
}
