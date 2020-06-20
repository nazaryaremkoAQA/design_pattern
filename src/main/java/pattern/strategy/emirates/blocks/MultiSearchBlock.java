package pattern.strategy.emirates.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DatePicker;

import java.util.Map;

public class MultiSearchBlock extends AbstractComponent {

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom1-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom2-suggest")
    private WebElement departureCity2;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo1-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo2-suggest")
    private WebElement arrivalCity2;

    @FindBy(id = "ctl00_c_CtWNW_txtD1")
    private WebElement departureDate;

    @FindBy(id = "ctl00_c_CtWNW_txtD2")
    private WebElement departureDate2;

    public MultiSearchBlock(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    public void fillAdvancedSearch(Map<String, String> searchDetails, DatePicker datePicker) {
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.departureDate.click();
        datePicker.selectToday();
        this.arrivalCity2.sendKeys(searchDetails.get("arrivalCity2"));
        this.departureDate2.click();
        datePicker.selectRandomFutureDate();
    }
}
