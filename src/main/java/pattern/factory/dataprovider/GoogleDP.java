package pattern.factory.dataprovider;

import org.testng.annotations.DataProvider;

public class GoogleDP {


    @DataProvider
    public Object[][] getGoogleData(){
        return new Object[][] { { "Selenium Webdriver" , 3} };
    }
}
