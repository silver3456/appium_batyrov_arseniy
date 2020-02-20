package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MyListsPageObject extends MainPageObject{

    public MyListsPageObject(AppiumDriver driver){
        super(driver);
    }

    private static final String
                FOLDER_BY_NAME_TPL="xpath://*[@text='{FOLDER_NAME}']", //var tpl
                ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']"; // Java (programming language)

    private static String nameOfFolderTPL(String name_of_folder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String nameOfArticleTPL(String name_of_article){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", name_of_article);
    }

    public void openFolderByName(String name_of_folder){
        String folder_xpath = nameOfFolderTPL(name_of_folder);
        this.waitAndClickByXpath(
                folder_xpath,
                "this article is missing at My Lists",
                10);
    }

    public void swipeByArticleToDelete(String article_title){
        String article_xpath = nameOfFolderTPL(article_title);
        this.swipeAndDeleteToLeft(article_xpath,
                "There is no such article");
        this.waitForArticleToDissappearByTitle(article_title);
        this.waitForArticleToAppearByTitle(article_title);
    }

    public void waitForArticleToDissappearByTitle(String article_title){
        String article_xpath = nameOfFolderTPL(article_title);
        this.waitWithIdNotVisable(article_xpath,
                "There is no such article" + article_title,
                5);

    }
    public void waitForArticleToAppearByTitle(String article_title){
        String article_xpath = nameOfFolderTPL(article_title);
        this.waitWithId(article_xpath,
                "Saved Article still present by title" + article_title,
                5);

    }

}
