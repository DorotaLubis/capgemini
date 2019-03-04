package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;
import waits.WaitForTitle;

public class JobSearchPage extends BasePage {

    @FindBy(css = "a.section__button--cookies")
    private WebElement cookiesCloseButton;

    @FindBy(css = "select[name=\"filter_location\"]")
    private WebElement locationFiled;

    @FindBy(css = "input[name='search_term']")
    private WebElement jobSearch;

    @Step("Getting title from Job Search page")
    public String getTitle() {
        WaitForTitle.getWebDriverWaitForTitle("Szukaj pracy");
        String pageTitle = DriverManager.getWebDriver().getTitle();
        return pageTitle;
    }

    @Step("Closing cookies")
    public JobSearchPage closingCookiesPanel() {
        WaitForElement.waitUntilElementIsClickable(cookiesCloseButton);
        cookiesCloseButton.click();
        return this;
    }

    @Step("Selecting Wroclaw city from location drop down list")
    public JobSearchPage selectingWroclawCityFromLocationDropDownList() {
        Select select = new Select(locationFiled);
        select.selectByValue("wroclaw");
        return this;
    }

    @Step("Typing phrase in search field and submitting")
    public JobSearchPage typePhraseIntoSearchFieldAndSubmit(String searchWords) {
        WaitForElement.waitUntilElementIsVisible(jobSearch);
        jobSearch.sendKeys(searchWords);
        jobSearch.submit();
        return this;
    }
}
