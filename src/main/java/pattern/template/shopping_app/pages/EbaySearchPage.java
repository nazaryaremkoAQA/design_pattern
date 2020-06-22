package pattern.template.shopping_app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbaySearchPage extends AbstractComponent {

    private String product;

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type = 'submit' and @value='Search']")
    private WebElement searchButton;

    public EbaySearchPage(WebDriver driver, String product) {
        super(driver);
        this.product = product;
        PageFactory.initElements(driver, this);
    }

    public String getProduct() {
        return product;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
