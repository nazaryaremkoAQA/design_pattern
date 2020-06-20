package pattern.strategy.emirates.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DatePicker;

import java.util.Map;

public class OneWaySearchBlock extends AbstractComponent {

    @FindBy(xpath = "//input[@id='ctl00_c_CtWNW_ddlFrom-suggest']")
    private WebElement departure;

    @FindBy(xpath = "//input[@id='txtDepartDate']")
    private WebElement departingTime;

    @FindBy(xpath = "//input[@id='ctl00_c_CtWNW_ddlTo-suggest']")
    private WebElement arrival;

    public OneWaySearchBlock(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public WebElement getDeparture() {
        return departure;
    }

    public WebElement getDepartingTime() {
        return departingTime;
    }

    public WebElement getArrival() {
        return arrival;
    }

    public void fillOutOneWay(Map<String, String> searchDetails, DatePicker datePicker) {
        this.wait.until((d) -> this.departure.isDisplayed());
        this.departure.sendKeys(searchDetails.get("departureCity"));
        this.arrival.sendKeys(searchDetails.get("arrivalCity"));
        this.departingTime.click();
        datePicker.selectToday();
    }
}
