package pattern.template.shopping_app.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pattern.template.shopping_app.pages.BasePage;

public class EbaySearchBlock extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search for anything']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@type = 'submit' and @value='Search']")
    private WebElement searchButton;

    public EbaySearchBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
