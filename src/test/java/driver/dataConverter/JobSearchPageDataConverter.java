package driver.dataConverter;

import io.qameta.allure.Step;

public class JobSearchPageDataConverter {

    private String[] resultsPhrase = null;

    @Step("Getting number of results as int from String format")
    public int getNumberOfResults(String resultsPhraseFromWebElement){
        resultsPhrase = resultsPhraseFromWebElement.split(" ");
        int result = Integer.parseInt(resultsPhrase[0]);
        return result;
    }

    public boolean getNumberOfCurrentPageAndLastPage(String numberOfCurrentAndLastPageFromWebEement){
        resultsPhrase = numberOfCurrentAndLastPageFromWebEement.split(" ");
        int currentPage = Integer.parseInt(resultsPhrase[1]);
        int lastPage = Integer.parseInt(resultsPhrase[3]);
        boolean isCurrentPageLastPage = (currentPage == lastPage);
        return isCurrentPageLastPage;
    }


}
