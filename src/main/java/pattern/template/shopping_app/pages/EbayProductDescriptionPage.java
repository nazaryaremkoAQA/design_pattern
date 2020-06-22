package pattern.template.shopping_app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayProductDescriptionPage extends AbstractComponent {

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement price;

    public EbayProductDescriptionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getPrice() {
        return price;
    }
}
