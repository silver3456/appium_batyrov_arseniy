package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    public void testCheckingTitleAfterRotation(){

        /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container"),
                "Can't find such id",
                5);

        String search_line = "Java (programming language)";

        MainPageObject.waitSendKeysAndClickByXpath(By.xpath("//*[contains(@text,'Search…')]"),
                search_line,
                "can not find path",
                5);

        MainPageObject.waitAndClickById(By.id("org.wikipedia:id/page_list_item_container"),
                "Can't find such id" + search_line,
                5);

        String title_before_rotation = MainPageObject.waitForElementAndGetAtrribute(
                By.id("org.wikipedia:id/view_page_title_text"),
                "text",
                "can't find article",
                15);

        driver.rotate(ScreenOrientation.LANDSCAPE);*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Java (programming language)");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = new ArticlePageObject (driver);

        String title_before_rotation = articlePageObject.getAttributeByArticleName();
        this.rotateScreenLandscape();
        String title_after_rotation = articlePageObject.getAttributeByArticleName();

        Assert.assertEquals("Article has been changed",
                title_before_rotation,
                title_after_rotation);

        this.rotateScreenPortrait();
        String title_after_second_rotation = articlePageObject.getAttributeByArticleName();

        Assert.assertEquals("Article has been changed",
                title_before_rotation,
                title_after_second_rotation);
    }

    @Test
    public void testCheckSearchArticleInBackground(){

        /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container"),
                "Can't find such id",
                5);

        String search_line = "Java (programming language)";

        MainPageObject.waitSendKeysAndClickByXpath(By.id("org.wikipedia:id/search_container"),
                search_line,
                "can not find path",
                5 );

        MainPageObject.waitWithXpath(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "can't find such article before background process",
                10);
                MainPageObject.waitWithXpath(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']"),
                "can't find such article after background process",
                10);*/

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Java (programming language)");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");

        this.runInBackground(3);

        SearchPageObject.waitForSearchResult("Object-oriented programming language");
    }
}
