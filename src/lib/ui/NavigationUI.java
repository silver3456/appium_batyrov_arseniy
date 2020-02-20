package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject {

    public NavigationUI(AppiumDriver driver){
        super(driver);
    }

    private static final String
                MY_LIST_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";


    public void clickMyList(){
        this.waitAndClickByXpath(MY_LIST_LINK,
                "can't find button My Lists",
                5);
    }


}
