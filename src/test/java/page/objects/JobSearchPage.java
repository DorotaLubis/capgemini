package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import waits.WaitForTitle;

public class JobSearchPage extends BasePage{

    @Step("Getting title from Job Search page")
    public String getTitle() {
        WaitForTitle.getWebDriverWaitForTitle("Szukaj pracy");
        String pageTitle = DriverManager.getWebDriver().getTitle();
        return pageTitle;
    }
}
