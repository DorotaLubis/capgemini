package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.JobSearchPage;

import static navigation.ApplicationURLs.TEST_JOB_IN_WROCLAW_SEARCH_URL;
import static org.testng.AssertJUnit.assertEquals;

public class CheckingNumberOfOffersTests extends TestBase {

    @Test
    @Description("The goal of this test is to change displaying volume of offer in page and check number of offer")
    public void changeDisplayingOfferOnPageAndCheckNumberOfOffer() {
        DriverUtils.navigateToPage(TEST_JOB_IN_WROCLAW_SEARCH_URL);

        JobSearchPage jobSearchPage = new JobSearchPage();

        int expectedNumberOfResults = jobSearchPage
                .closeCookiesPanel()
                .clickOnLastOptionFromPageShowLabel()
                .getNumberOfResultsFromResultsTitle();

        int numberOfCollectedOffers = jobSearchPage.numberOfCollectedOffers();

        assertEquals("Incorrect offers number", expectedNumberOfResults, numberOfCollectedOffers);
    }
}
