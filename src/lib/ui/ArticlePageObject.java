package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
    TITLE = "id:org.wikipedia:id/view_page_title_text",
    FOOTER_ELEMENT = "xpath://*[@resource-id='org.wikipedia:id/page_external_link'][@text='View page in browser']",
    OPTIONS = "xpath://android.widget.ImageView[@content-desc='More options']",
    ADD_TO_MY_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']",
    ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    public WebElement getTitleById(){
        return this.waitWithId(TITLE,
                "can't get Article Name",
                15);
    }

    public String getAttributeByArticleName(){
        WebElement element = getTitleById();
        return element.getAttribute("text");
    }

    public void swipeToFooter(){
        this.swipeUpToFindElements(
                FOOTER_ELEMENT,
                "Footer is unreachable",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder){

        this.waitAndClickByXpath(OPTIONS,
                "can't find button 'More Options'",
                5);

        this.waitAndClickByXpath(ADD_TO_MY_LIST_BUTTON,
                "there is no such 'Reading list'",
                5);

        this.waitAndClickById(ADD_TO_MY_LIST_OVERLAY,
                "there is no such button with text 'GOT IT'",
                5);

        this.waitAndClearById(MY_LIST_NAME_INPUT,
                "no such field to clear",
                5); // clearing field

        this.waitSendKeysAndClickByXpath(MY_LIST_NAME_INPUT,
                name_of_folder,
                "can't type to entry field",
                5); // entering into field

        this.waitAndClickByXpath(MY_LIST_OK_BUTTON,
                "button OK is missing",
                5);
    }

    public void closeArticle(){
        this.waitAndClickByXpath(CLOSE_ARTICLE_BUTTON,
                "can't find button X to return to main menu",
                5);
    }

}
