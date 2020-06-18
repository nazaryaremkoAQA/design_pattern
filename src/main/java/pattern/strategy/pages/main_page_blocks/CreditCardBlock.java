package pattern.strategy.pages.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreditCardBlock extends AbstractComponent {

    @FindBy(id = "cc")
    private WebElement creditCard;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    public CreditCardBlock(WebDriver driver) {
        super(driver);
    }

    public void fillOutCC(String creditCard, String year, String cvv){
        this.wait.until((d) -> this.creditCard.isDisplayed());
        this.creditCard.sendKeys(creditCard);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.creditCard.isDisplayed());
    }
}
