package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_KEY = "xpath://XCUIElementTypeSearchField[@value='Java']";
        SEARCH_CANCEL_BUTTON = "id:Close";
        SEARCH_RESULT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{TPL2}']";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_container']";
        SEARCH_RESULT_ELEMENT_NOT_EMPTY="xpath://*[@text='No results found']";}

    public iOSSearchPageObject(AppiumDriver driver){
        super(driver);
    }
}
