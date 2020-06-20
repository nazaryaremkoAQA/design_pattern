package pattern.strategy.emirates.actions;

import org.openqa.selenium.WebDriver;
import pattern.strategy.emirates.blocks.ReturnSearchBlock;
import pattern.strategy.emirates.blocks.TypeOfSearchBlock;
import utils.DatePicker;

import java.util.Map;

public class ReturnFlightSearchActions implements IFlightSearch {

    private ReturnSearchBlock returnSearchBlock;
    private TypeOfSearchBlock typeOfSearchBlock;
    private DatePicker datePicker;

    public ReturnFlightSearchActions(WebDriver driver) {
        this.returnSearchBlock = new ReturnSearchBlock(driver);
        this.typeOfSearchBlock = new TypeOfSearchBlock(driver);
    }

    @Override
    public void search(Map<String, String> searchDetails) {
        typeOfSearchBlock.clickOnReturnWay();
        returnSearchBlock.fillReturnWay(searchDetails,datePicker);
    }

    @Override
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }
}