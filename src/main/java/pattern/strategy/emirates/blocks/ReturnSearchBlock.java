package pattern.strategy.emirates.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DatePicker;

import java.util.Map;

public class ReturnSearchBlock extends AbstractComponent {

    @FindBy(xpath = "//div[@id='dvFrom']/input[@placeholder='Departure airport']")
    private WebElement departure;

    @FindBy(xpath = "//div[@class='fare-inputs-row']//input[@placeholder='Departing']")
    private WebElement departingTime;

    @FindBy(xpath = "//div[@class='fare-inputs-row m-none']/input[@placeholder='Arrival airport']")
    private WebElement arrival;

    @FindBy(xpath = "//input[@id='txtarrivaldate']")
    private WebElement returningTime;

    public ReturnSearchBlock(WebDriver driver) {
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

    public WebElement getReturningTime() {
        return returningTime;
    }

    public void fillReturnWay(Map<String, String> searchDetails, DatePicker datePicker) {
        this.wait.until((d) -> this.departure.isDisplayed());
        this.departure.sendKeys(searchDetails.get("departureCity"));
        this.arrival.sendKeys(searchDetails.get("arrivalCity"));
        this.departingTime.click();
        datePicker.selectToday();
        this.returningTime.click();
        datePicker.selectRandomFutureDate();
    }
}
