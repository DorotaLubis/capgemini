package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class LandingPageTopMenu extends BasePage{

    @FindBy (css = "li#menu-item-11201")
    private WebElement careerMenuBar;

    @FindBy (css = "ul.sub-menu a[href*='wyszukiwarka']")
    private  WebElement searchLinkInCareerTopMenuBar;

    @Step("Hover Over Career top menu bar")
    public LandingPageTopMenu hoverOverCareerTopMenuBar(){
        WaitForElement.waitUntilElementIsVisible(careerMenuBar);
        actions.moveToElement(careerMenuBar).perform();
        log().info("Hover over Career top menu bar link");
        return this;
    }

    @Step("Click on Job Search link from Career drop down list")
    public JobSearchPage clickOnJobSearchLinkFromCareerDropDownList(){
        WaitForElement.waitUntilElementIsVisible(searchLinkInCareerTopMenuBar);
        searchLinkInCareerTopMenuBar.click();
        return new JobSearchPage();
    }
}
