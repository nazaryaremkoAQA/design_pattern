package pattern.strategy.emirates.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pattern.strategy.emirates.blocks.OneWaySearchBlock;
import pattern.strategy.emirates.actions.IFlightSearch;
import pattern.strategy.emirates.blocks.MultiSearchBlock;
import pattern.strategy.emirates.blocks.ReturnSearchBlock;
import pattern.strategy.emirates.blocks.TypeOfSearchBlock;
import utils.DatePicker;

import java.util.Map;

public class MainEmiratesPage {

    private MultiSearchBlock multiSearchBlock;
    private OneWaySearchBlock oneWaySearchBlock;
    private ReturnSearchBlock returnSearchBlock;
    private TypeOfSearchBlock typeOfSearchBlock;
    private final WebDriver driver;
    private final By seassionExpired = By.className("ts-session-expire--link");
    private IFlightSearch flightSearch;

    @FindBy(xpath = "//a/span[contains(text(),'Search')]")
    private WebElement searchButton;

    public MainEmiratesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo(){
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
        this.driver.findElements(seassionExpired)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void setFlightSearch(IFlightSearch flightSearch){
        this.flightSearch = flightSearch;
        PageFactory.initElements(driver, this.flightSearch);
        this.flightSearch.setDatePicker(PageFactory.initElements(driver, DatePicker.class));
    }

    public void searchForFlights(Map<String, String> searchDetails){
        this.flightSearch.search(searchDetails);
    }
}
