package pattern.strategy.emirates.actions;

import org.openqa.selenium.WebDriver;
import pattern.strategy.emirates.blocks.MultiSearchBlock;
import pattern.strategy.emirates.blocks.TypeOfSearchBlock;
import utils.DatePicker;

import java.util.Map;

public class AdvancedFlightSearchActions implements IFlightSearch {

    private MultiSearchBlock multiSearchBlock;
    private TypeOfSearchBlock typeOfSearchBlock;
    private DatePicker datePicker;

    public AdvancedFlightSearchActions(WebDriver driver) {
        this.multiSearchBlock = new MultiSearchBlock(driver);
        this.typeOfSearchBlock = new TypeOfSearchBlock(driver);
    }

    @Override
    public void search(Map<String, String> searchDetails) {
        typeOfSearchBlock.clickOnAdvanced();
        multiSearchBlock.fillAdvancedSearch(searchDetails,datePicker);
    }

    @Override
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}
