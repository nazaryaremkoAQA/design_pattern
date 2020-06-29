package pattern.test.factory;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pattern.base.BaseTest;
import pattern.factory.GoogleFactory;
import pattern.factory.GooglePage;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword){
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();
        System.out.println("Result Count : " + resultCount);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "design patterns"},
                {"SA", "docker"},
                {"ES", "selenium"}
        };
    }

}
