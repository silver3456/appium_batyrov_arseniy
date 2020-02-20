package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;
import org.openqa.selenium.By;

public class SearchTests extends CoreTestCase {

    @Test
    public void test(){

      /*  MainPageObject.waitAndClickByXpath(By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "can't find xpath",
                5);

        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                "Java",
                "can not find path",
                5 );
        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_src_text"),
                "can't erase data",
                5);*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внещний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

    }

    @Test
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput("Search Wikipedia");
        // SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
        /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container") ,
                "Can't find such id",
                5);

        MainPageObject.waitSendKeysAndClickByXpath(By.id("org.wikipedia:id/search_container"),
                "Java",
                "can not find path",
                5 );

        MainPageObject.waitAndClearById(By.id("org.wikipedia:id/search_src_text"),
                "can't erase data",
                5); //clearing results

        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_close_btn"),
                "Can't find such id",
                5);

        MainPageObject.waitWithIdNotVisable(By.id("org.wikipedia:id/search_close_btn"),
                "Can find such id, because it's presented",
                5);*/

    }


    /*@Test
    public void testCompareTitleWipeUp(){
        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container") ,
                "Can't find such id",
                5);

        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                "Java (programming language)",
                "can not find path",
                5);

        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/page_list_item_container"),
                "Can't find such id",
                5);

        MainPageObject.waitWithId(By.id("org.wikipedia:id/view_page_title_text"),
                "can't locate item",
                15); // takes longer then needed

        MainPageObject.swipeUp(4000);
        MainPageObject.swipeUp(4000);
        MainPageObject.swipeUp(4000);
    }*/ // needs some refactoring

    @Test
    public void testAmountNonEmptySearch(){

    /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container"),
                "Can't find such id",
                5);

        String search_line = "Linkin Park Discography";
        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "can not find path",
                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";

        MainPageObject.waitWithXpath(By.xpath(search_result_locator),
                "can't find anything by search line" + search_line,
                15);

        int amount_of_search_results = MainPageObject.getAmountOfElements(By.xpath(search_result_locator));

        Assert.assertTrue("Can't find any elements",
                amount_of_search_results > 0);*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        String search_line = "Linkin Park Discography";
        SearchPageObject.typeSearchLine(search_line);

        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        assertTrue("Can't find any elements",
                amount_of_search_results > 0);
    }

    @Test
    public void testAmountOfEmptySearch() {

    /* String search_line = "mk1564";
        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "can not find path",
                5);

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']/*[@resource-id='org.wikipedia:id/page_list_item_container']";
        String no_result_label = "//*[@text='No results found']";
        MainPageObject.waitWithXpath(By.xpath(no_result_label),
                "can't find empty result label " + search_line,
                15);

        MainPageObject.assertElementNotPresent(By.xpath(search_result_locator),
                "we found some results by request" + search_line);*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        String search_line = "mk1564";
        SearchPageObject.typeSearchLine(search_line);
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.AssertNoResultOfSearch();
    }


    /*@Test
    public void testCheckSearchArticleInBackgroundWithAssert(){
        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container"),
                "Can't find such id",
                5);

        String search_line = "Java (programming language)";

        MainPageObject.waitSendKeysAndClickByXpath(By.id("org.wikipedia:id/search_container"),
                search_line,
                "can not find path",
                5 );

        String title_before_background = MainPageObject.waitForElementAndGetAtrribute(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "text",
                "can't find such attribute",
                15
        );

        this.runInBackground(3);

        String title_after_background=MainPageObject.waitForElementAndGetAtrribute(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "text",
                "can't find such attribute",
                15
        );
        assertEquals("attributes don't match",title_before_background,title_after_background);
        System.out.println(title_after_background);
    }*/
}
