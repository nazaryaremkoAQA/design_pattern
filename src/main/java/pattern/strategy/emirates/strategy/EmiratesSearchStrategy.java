package pattern.strategy.emirates.strategy;

import org.openqa.selenium.WebDriver;
import pattern.strategy.emirates.actions.AdvancedFlightSearchActions;
import pattern.strategy.emirates.actions.IFlightSearch;
import pattern.strategy.emirates.actions.OneWayFlightSearchActions;
import pattern.strategy.emirates.actions.ReturnFlightSearchActions;

public enum EmiratesSearchStrategy {

    ONE_WAY {
        public IFlightSearch action(WebDriver driver) {
            return new OneWayFlightSearchActions(driver);
        }
    },
    RETURN {
        public IFlightSearch action(WebDriver driver) {

            return new ReturnFlightSearchActions(driver);
        }
    },
    ADVANCED {
        public IFlightSearch action(WebDriver driver) {
            return new AdvancedFlightSearchActions(driver);
        }
    };

    public abstract IFlightSearch action(WebDriver driver);

}
