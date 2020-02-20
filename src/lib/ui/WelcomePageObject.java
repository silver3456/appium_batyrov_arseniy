package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

    public class WelcomePageObject extends MainPageObject{

        private static final String
                TEST = "//XCUIElementTypeButton[@name=\"Learn more about Wikipedia\"]",
                STEP_LEARN_MORE_LINK = "Learn more about Wikipedia",
                NEW_WAY_TO_EXPLORE = "New ways to explore",
                ADD_EDIT_LANGUAGE = "Add or edit preferred languages",
                LEARN_MORE_DATA = "Learn more about data collected",
                NEXT_BUTTON = "Next",
                GET_STARTED_BUTTON = "Get started"; // ACCESABILITYID is unique locator within XCUITEST

    public WelcomePageObject(AppiumDriver driver){
        super(driver);
    }

    public void waitForLearnMoreWikipedia(){
        this.waitWithId(STEP_LEARN_MORE_LINK,
                "Can't find link 'Learn more about Wikipedia'",
                10);
    }

    public void waitForNewWaysToExplore(){
            this.waitWithId(NEW_WAY_TO_EXPLORE,
                    "Can't find link 'New ways to explore'",
                    10);
    }

    public void waitForAddOrEditPrefferedLanguages(){
            this.waitWithId(ADD_EDIT_LANGUAGE,
                    "Can't find link 'Add or edit preferred languages'",
                    10);
    }

    public void waitForLearnMoreDataCollected(){
            this.waitWithId(LEARN_MORE_DATA,
                    "Can't find link 'Add or edit preferred languages'",
                    20);
    }

    public void clickNextButton(){
        this.waitAndClickById(NEXT_BUTTON,
                "Can't locate Next Button",
                20);
    }

    public void clickGetStartedButton(){
            this.waitAndClickById(GET_STARTED_BUTTON,
                    "Can't locate Next Button",
                    20);
    }
}
