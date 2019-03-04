package navigation;

import configuration.AppProperties;

public class ApplicationURLs {

    public static final String APPLICATION_URL = AppProperties.getAllUrl();
    public static final String JOB_SEARCH_URL = APPLICATION_URL + "kariera/wyszukiwarka-ofert-pracy/";
    public static final String TEST_JOB_IN_WROCLAW_SEARCH_URL = JOB_SEARCH_URL + "?search_term=Test&filter_location=wroclaw";
}
