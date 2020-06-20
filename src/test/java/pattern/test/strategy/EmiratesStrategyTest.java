package pattern.test.strategy;

import org.testng.annotations.Test;
import pattern.strategy.emirates.dataprovider.SearchDataDP;
import pattern.strategy.emirates.pages.MainEmiratesPage;
import pattern.strategy.emirates.strategy.EmiratesSearchStrategy;
import test.base.BaseTest;

import java.util.Map;

public class EmiratesStrategyTest extends BaseTest {

    @Test(dataProvider = "searchDataForEmirates", dataProviderClass = SearchDataDP.class)
    public void googleSearchStrategy(EmiratesSearchStrategy strategy, Map<String,String> searchInfo) throws InterruptedException {

        MainEmiratesPage emiratesPage = new MainEmiratesPage(driver);
        emiratesPage.setFlightSearch(strategy.action(driver));
        emiratesPage.goTo();
        emiratesPage.searchForFlights(searchInfo);

    }
}