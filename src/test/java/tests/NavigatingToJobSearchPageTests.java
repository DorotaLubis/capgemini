package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import page.objects.JobSearchPage;
import page.objects.LandingPageTopMenu;

import static navigation.ApplicationTitle.EXPECTED_JOB_SEARCH_PAGE_TITLE;
import static navigation.ApplicationURLs.APPLICATION_URL;
import static org.testng.AssertJUnit.assertEquals;

public class NavigatingToJobSearchPageTests extends TestBase {

    @Test
    @Description("The goal of this test is to navigate to Job Search page and check if page title is correct")
    public void navigateToJobSearchPage() {
        DriverUtils.navigateToPage(APPLICATION_URL);

        LandingPageTopMenu landingPageTopMenu = new LandingPageTopMenu();
        landingPageTopMenu
                .hoverOverCareerTopMenuBar()
                .clickOnJobSearchLinkFromCareerDropDownList();

        JobSearchPage jobSearchPage = new JobSearchPage();
        String jobSearchPageTitle = jobSearchPage.getTitle();

        assertEquals("Page title is incorrect.",EXPECTED_JOB_SEARCH_PAGE_TITLE, jobSearchPageTitle);
    }
}
