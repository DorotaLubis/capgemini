package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.JobSearchPage;

import static navigation.ApplicationURLs.JOB_SEARCH_URL;
import static org.testng.AssertJUnit.assertTrue;

public class SearchingOfferUsingSearchFieldWithSelectingWroclawCityTests extends TestBase {

    @Test
    @Description("The goal of this test is to select location Wroclaw from location drop down list, search job using search field and check results")
    public void searchOfferInputtingPhraseAndUsingLocationWroclaw() {
        DriverUtils.navigateToPage(JOB_SEARCH_URL);
        String searchingPhrase = "Test";
        String expectedPartOfLink = "Test&filter_location=wroclaw";

        JobSearchPage jobSearchPage = new JobSearchPage();
        Boolean currentUrlContainsExpectedPartOfLink =
                jobSearchPage
                        .closeCookiesPanel()
                        .typePhraseIntoSearchFieldAndSubmit(searchingPhrase)
                        .selectWroclawCityFromLocationDropDownList()
                        .getUrlAndSplitIt(expectedPartOfLink);

        assertTrue("Current URL not contains expected phrase", currentUrlContainsExpectedPartOfLink);
    }
}
