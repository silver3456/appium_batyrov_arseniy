package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {
    @Test
    public void testCompareTitle(){

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Java (programming language)");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getAttributeByArticleName();

       /* MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container") ,
                "Can't find such id",
                5);

        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                "Java (programming language)",
                "can not find path",
                5);

        MainPageObject.waitAndClickById(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "Can't find such id",
                5);

        WebElement title_element = MainPageObject.waitWithId(By.id("org.wikipedia:id/view_page_title_text"),
                "can't locate item",
                15); // takes longer then needed

        String article_title = title_element.getAttribute("text"); //getting text attribute as Title of Article*/

        assertEquals("there's no such title",
                "Java (programming language)",
                article_title);
    }
    @Test
    public void testCompareTitleSwipeUpUntil(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внещний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Appium");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.getTitleById();
        ArticlePageObject.swipeToFooter();

        /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container") ,
            "Can't find such id",
            5);

        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                "Appium",
                "can not find path",
                5);

        MainPageObject.waitAndClickByXpath(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Can't find such id",
                5);

        MainPageObject.waitWithId(By.id("org.wikipedia:id/view_page_title_text"),
                "can't locate item",
                5); // takes longer then needed

        MainPageObject.swipeUpToFindElements(By.xpath("//*[@resource-id='org.wikipedia:id/page_external_link'][@text='View page in browser']"),
                "there's no end of an article", 15);*/
    }
}
