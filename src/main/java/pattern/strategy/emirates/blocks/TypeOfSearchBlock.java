package pattern.strategy.emirates.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TypeOfSearchBlock extends AbstractComponent {

    @FindBy(xpath = "//*[@id='Div1']")
    private WebElement returnSearch;

    @FindBy(xpath = "//div[@id='dvRadioOneway']")
    private WebElement onewaySearch;

    @FindBy(xpath = "//*[@id='dvRadioMulti']")
    private WebElement multipleSearch;

    public TypeOfSearchBlock(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public WebElement getReturnSearch() {
        return returnSearch;
    }

    public WebElement getOnewaySearch() {
        return onewaySearch;
    }

    public WebElement getMultipleSearch() {
        return multipleSearch;
    }

    public void clickOnOneWay() {
        wait.until(d -> onewaySearch.isDisplayed());
        if (!onewaySearch.isSelected())
            this.onewaySearch.click();

    }

    public void clickOnReturnWay() {
        wait.until(d -> returnSearch.isDisplayed());
        if (!returnSearch.isSelected())
            this.returnSearch.click();
    }

    public void clickOnAdvanced() {
        wait.until(d -> multipleSearch.isDisplayed());
        if (!multipleSearch.isSelected())
            this.multipleSearch.click();
    }
}
