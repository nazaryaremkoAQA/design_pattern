package test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pattern.base.BaseTest;
import pattern.factory.dataprovider.GoogleDP;
import google.pages_for_udemy.main.GoogleMainPage;
import google.pages_for_udemy.result.GoogleResultPage;

public class GoogleUdemyTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void prepare() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getGoogleData", dataProviderClass = GoogleDP.class)
    public void googleTest(String text, int number) {
        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getWidget().isDisplayed());

        googleMainPage.getWidget().enter(text);

        Assert.assertTrue(googleMainPage.getSuggestion().isDisplayed());

        googleMainPage.getSuggestion().clickSuggestionByIndex(number);

        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(text);
        Assert.assertTrue(googleResultPage.getSuggestion().isDisplayed());

        googleResultPage.getSuggestion().clickSuggestionByIndex(number);

        googleResultPage.getNavigationBar().goToImages();

        System.out.println(googleResultPage.getResultState().getStat());


    }

}