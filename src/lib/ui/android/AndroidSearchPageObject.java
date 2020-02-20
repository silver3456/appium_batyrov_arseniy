package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {

     static {SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'{TPL}')]";
             SEARCH_KEY = "xpath://*[contains(@text,'Search…')]";
             SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
             SEARCH_RESULT = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{TPL2}']";
             SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_container']";
             SEARCH_RESULT_ELEMENT_NOT_EMPTY="xpath://*[@text='No results found']";}


    public AndroidSearchPageObject(AppiumDriver driver){
        super(driver);
    }
}
