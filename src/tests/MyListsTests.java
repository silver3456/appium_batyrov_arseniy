package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveArticleAndDelete(){

        /*MainPageObject.waitAndClickById(By.id("org.wikipedia:id/search_container") ,
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
                5); // takes longer then needed

        MainPageObject.waitAndClickByXpath(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "can't find button X to return to main menu",
                5);
        MainPageObject.waitAndClickByXpath(By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "can't find button My Lists",
                5);
        MainPageObject.swipeAndDeleteToLeft(By.xpath("//*[@text='Java (programming language)']"),
                "There is no such article");

        MainPageObject.waitWithIdNotVisable(By.xpath("//*[@text='Java (programming language)']"),
                "There is no such article",
                5);

        MainPageObject.waitAndClickByXpath(By.xpath("//*[@text='"+name_of_folder+"']"),
                "this article is missing at My Lists",
                10);*/

        /*SearchPageObject SearchPageObject = new SearchPageObject(driver); // вверху тоже самое, но теперь мы улучшили внешний вид сестов
        SearchPageObject.initSearchInput("Search Wikipedia");
        SearchPageObject.typeSearchLine("Java (programming language)");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitWithId(By.id("org.wikipedia:id/view_page_title_text"),
                "can't locate Substring",
                5);
        String article_title = ArticlePageObject.getAttributeByArticleName();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);

        ArticlePageObject.closeArticle();
        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();
        MyListsPageObject myListsPageObject = new MyListsPageObject(driver);
        myListsPageObject.openFolderByName(name_of_folder);
        myListsPageObject.swipeByArticleToDelete(article_title);*/
    }
}
