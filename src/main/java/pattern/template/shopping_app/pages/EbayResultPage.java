package pattern.template.shopping_app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayResultPage extends AbstractComponent{


    @FindBy(xpath = "(//a/h3[@class='s-item__title'])[1]")
    private WebElement item;

    public EbayResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public WebElement getItem() {
        return item;
    }
}
