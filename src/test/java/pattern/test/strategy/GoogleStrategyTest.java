package pattern.test.strategy;

import org.testng.Assert;
import org.testng.annotations.Test;
import pattern.strategy.google_app.actions.ISearchStrategy;
import pattern.strategy.google_app.dataprovider.SearchDataDP;
import pattern.strategy.google_app.pages.GooglePage;
import pattern.strategy.google_app.strategy.GoogleSearchStrategy;
import test.base.BaseTest;

public class GoogleStrategyTest extends BaseTest {

    @Test(dataProvider = "searchDataForGoogle" , dataProviderClass = SearchDataDP.class)
    public void googleSearchStrategy(GoogleSearchStrategy strategy, String searchString, int resultCount) throws InterruptedException {

        GooglePage google = new GooglePage(driver);
        google.goTo();
        google.setStrategy(strategy.action(driver));
        google.search(searchString);
        Assert.assertEquals(resultCount, google.getResultsCount());

    }
}
