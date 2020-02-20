package tests.iOS;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class getStartedTest extends CoreTestCase {

    @Test
    public void testPassThroughWelcome(){

        if(Platform.getInstance().isAndroid()){
            return; //skip the whole test if it's android platform
        }
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);

        welcomePageObject.waitForLearnMoreWikipedia();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWaysToExplore();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPrefferedLanguages();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForLearnMoreDataCollected();
        welcomePageObject.clickGetStartedButton();
    }

    @Test
    public void test(){

    }
}
