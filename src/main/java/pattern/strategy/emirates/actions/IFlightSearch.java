package pattern.strategy.emirates.actions;

import utils.DatePicker;

import java.util.Map;

public interface IFlightSearch {

    void search(Map<String, String> searchDetails);
    void setDatePicker(DatePicker datePicker);

}
