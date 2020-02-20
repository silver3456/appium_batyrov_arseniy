package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class SearchPageObject extends MainPageObject{

    public SearchPageObject(AppiumDriver driver){

        super(driver);//get driver from MainPageObject
    }

     protected static String
        SEARCH_INIT_ELEMENT,
        SEARCH_KEY,
        SEARCH_CANCEL_BUTTON,
        SEARCH_RESULT,
        SEARCH_RESULT_ELEMENT,
        SEARCH_RESULT_ELEMENT_NOT_EMPTY;

    private static String getStringResultOfElementTPL(String substring){ //в данном методе меняется ТОЛЬКО часть строки при помощи метода replace
        return SEARCH_INIT_ELEMENT.replace("{TPL}",substring);
    }

    private static String getStringSearchResultTPL(String substring){ //в данном методе меняется ТОЛЬКО часть строки при помощи метода replace
        return SEARCH_RESULT.replace("{TPL2}",substring);
    }

    public void waitForCancelButtonToAppear(){
        waitWithId(SEARCH_CANCEL_BUTTON,
                "button isn't ready yet",
                5);

    }
    public void waitForCancelButtonToDisappear(){
        waitWithIdNotVisable(SEARCH_CANCEL_BUTTON,
                "button still available",
                5);
    }

    public void clickCancelSearch(){
        waitAndClickById(SEARCH_CANCEL_BUTTON,
                "can't find and click cancel search button",
                6);
    }


    public void initSearchInput(String substring){
        String search_result_TPL = getStringResultOfElementTPL(substring);
        this.waitAndClickByXpath(search_result_TPL,
                "can't find xpath",
                10);

    }

    public void typeSearchLine(String search_line){
        this.waitSendKeysAndClickByXpath(SEARCH_KEY,
                search_line,
                "can not find path",
                6);
    }

    public void waitForSearchResult(String substring){
        String search_result_TPL = getStringSearchResultTPL(substring);
        this.waitWithXpath(search_result_TPL,
                "can't erase data",7);
    }

    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getStringSearchResultTPL(substring);
        this.waitAndClickByXpath(search_result_xpath,
                "can't find and click for search result with substring",
                15);
    }

    public int getAmountOfFoundArticles(){

        this.waitWithXpath(SEARCH_RESULT_ELEMENT,
                "can't find anything by search line",
                15
        );

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);
    }

    public void waitForEmptyResultLabel(){
        this.waitWithXpath(SEARCH_RESULT_ELEMENT_NOT_EMPTY,
                "can't find empty result elements",
                15);
    }

    public void AssertNoResultOfSearch(){
        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT,
                "No results will shot");
    }
}
