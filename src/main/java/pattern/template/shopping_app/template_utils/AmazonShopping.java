package pattern.template.shopping_app.template_utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private Wait wait;
    private String product;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit' and @value='Go']")
    private WebElement searchButton;

    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    @FindBy(id = "priceblock_ourprice")
    private WebElement price;

    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.amazon.com/");
    }

    @Override
    public void searchItem() {
        this.searchBox.sendKeys(this.product);
        this.searchButton.click();
    }

    @Override
    public void selectProduct() {
        this.wait.until(i -> item.isDisplayed());
        this.item.click();
    }

    @Override
    public String buy() {
        return price.getText();
    }
}
