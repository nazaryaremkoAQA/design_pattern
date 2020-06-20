package pattern.test.factory;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pattern.base.BaseTest;
import pattern.factory.dataprovider.GoogleDP;
import pattern.factory.EnglishFactory;
import pattern.factory.GooglePage;
import pattern.factory.IGoogleFactory;

public class GoogleFactoryTest  extends BaseTest {

    private IGoogleFactory googleFactory;
    private GooglePage googlePage;

    @BeforeTest
    public void prepare() {
        googleFactory = new EnglishFactory();
        googlePage = googleFactory.createPage(driver);
    }

    @Test(dataProvider = "getGoogleData", dataProviderClass = GoogleDP.class)
    public void googleTest(String text, int number) {
        googlePage.launchSite();
        googlePage.search(text);
        System.out.println(googlePage.getResultsCount());
    }
}
