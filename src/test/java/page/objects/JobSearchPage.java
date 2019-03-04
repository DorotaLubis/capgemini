package page.objects;

import driver.dataConverter.JobSearchPageDataConverter;
import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import waits.WaitForElement;
import waits.WaitForTitle;

import java.util.ArrayList;
import java.util.List;

public class JobSearchPage extends BasePage {

    @FindBy(css = "a.section__button--cookies")
    private WebElement cookiesCloseButton;

    @FindBy(css = "select[name=\"filter_location\"]")
    private WebElement locationFiled;

    @FindBy(css = "input[name='search_term']")
    private WebElement jobSearch;

    @FindBy(css = "nav.pagination__show ul li:last-child")
    private WebElement pagesShowLabel;

    @FindBy(css = "h2.section__regular-title")
    private WebElement numberOfResultsTitle;

    @FindBy(css = "div.pagination__top div.pagination__current-page")
    private WebElement currentPageTopStatus;

    @FindBy(css = "a.pagination__next")
    private WebElement nextButton;

    @FindBy(css = "div.card_default__content")
    List<WebElement> offers;
    private WebElement singleOffer;

    @Step("Getting title from Job Search page")
    public String getTitle() {
        WaitForTitle.getWebDriverWaitForTitle("Szukaj pracy");
        String pageTitle = DriverManager.getWebDriver().getTitle();
        return pageTitle;
    }

    @Step("Gettin part of URL")
    public boolean getUrlAndSplitIt(String string) {
        String currentUrl = DriverManager.getWebDriver().getCurrentUrl();
        Boolean currentUrlContainsString = currentUrl.contains(string);
        return currentUrlContainsString;
    }

    @Step("Closing cookies")
    public JobSearchPage closeCookiesPanel() {
        WaitForElement.waitUntilElementIsClickable(cookiesCloseButton);
        cookiesCloseButton.click();
        return this;
    }

    @Step("Typing phrase in search field and submitting")
    public JobSearchPage typePhraseIntoSearchFieldAndSubmit(String searchWords) {
        WaitForElement.waitUntilElementIsVisible(jobSearch);
        jobSearch.sendKeys(searchWords);
        jobSearch.submit();
        return this;
    }

    @Step("Selecting Wroclaw city from location drop down list")
    public JobSearchPage selectWroclawCityFromLocationDropDownList() {
        new Select(locationFiled).selectByValue("wroclaw");
        return this;
    }

    @Step("Clicking on last option from page label")
    public JobSearchPage clickOnLastOptionFromPageShowLabel() {
        WaitForElement.waitUntilElementIsVisible(pagesShowLabel);
        pagesShowLabel.click();
        new Actions(DriverManager.getWebDriver()).moveToElement(pagesShowLabel).perform();
        return this;
    }

    @Step("Getting number of results from results title")
    public int getNumberOfResultsFromResultsTitle() {
        int results = new JobSearchPageDataConverter().getNumberOfResults(numberOfResultsTitle.getText());
        return results;
    }

    public int numberOfCollectedOffers() {
        boolean isLastPage;
        List<WebElement> allOffers = new ArrayList<>();

        do {
            isLastPage = new JobSearchPageDataConverter().getNumberOfCurrentPageAndLastPage(currentPageTopStatus.getText());
            allOffers.addAll(offers);
            if (isLastPage == false) {
                new Actions(DriverManager.getWebDriver()).moveToElement(nextButton).perform();
                nextButton.click();
            }
        } while (isLastPage == false);

        return allOffers.size();
    }
}

