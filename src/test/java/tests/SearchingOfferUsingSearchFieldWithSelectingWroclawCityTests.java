package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.JobSearchPage;

import static navigation.ApplicationURLs.JOB_SEARCH_URL;

public class SearchingOfferUsingSearchFieldWithSelectingWroclawCityTests extends TestBase {

    @Test
    @Description("The goal of this test is to select location Wroclaw, search job use word Test and check results")
    public void searchOfferInputtingPhraseAndUsingLocationWroclaw() {
        DriverUtils.navigateToPage(JOB_SEARCH_URL);

        JobSearchPage jobSearchPage = new JobSearchPage();
        jobSearchPage
                .closingCookiesPanel()
                .selectingWroclawCityFromLocationDropDownList()
                .typePhraseIntoSearchFieldAndSubmit("Test");
    }
}
