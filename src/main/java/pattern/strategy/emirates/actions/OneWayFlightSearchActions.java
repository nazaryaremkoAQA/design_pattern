package pattern.strategy.emirates.actions;

import org.openqa.selenium.WebDriver;
import pattern.strategy.emirates.blocks.OneWaySearchBlock;
import pattern.strategy.emirates.blocks.TypeOfSearchBlock;
import utils.DatePicker;

import java.util.Map;

public class OneWayFlightSearchActions implements IFlightSearch {

    private OneWaySearchBlock oneWaySearchBlock;
    private TypeOfSearchBlock typeOfSearchBlock;
    private DatePicker datePicker;

    public OneWayFlightSearchActions(WebDriver driver) {
        this.oneWaySearchBlock = new OneWaySearchBlock(driver);
        this.typeOfSearchBlock = new TypeOfSearchBlock(driver);
    }

    @Override
    public void search(Map<String, String> searchDetails) {
        typeOfSearchBlock.clickOnOneWay();
        setDatePicker(datePicker);
        oneWaySearchBlock.fillOutOneWay(searchDetails, datePicker);
    }

    @Override
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
