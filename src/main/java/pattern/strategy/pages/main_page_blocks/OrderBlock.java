package pattern.strategy.pages.main_page_blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderBlock extends AbstractComponent{

    @FindBy(id = "buy")
    private WebElement buy;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.orderNumber.isDisplayed());
    }

    public OrderBlock(WebDriver driver) {
        super(driver);
     }

    public String getOrder(){
        this.buy.click();
        return this.orderNumber.getText();
    }
}
