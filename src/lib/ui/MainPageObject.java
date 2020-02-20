package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {

    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitWithXpath(String locator, String error_message, long timeoutInSeconds){
        By by = this.getLocatorString(locator);
        WebDriverWait wait =  new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitWithId(String locator,String error_message,long timeoutInSeconds){
        By by = this.getLocatorString(locator);
        WebDriverWait wait =  new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitAndClickByXpath(String locator, String error_message, long timeoutInSeconds){
        WebElement waitClick = waitWithXpath(locator, error_message, timeoutInSeconds);
        waitClick.click();
        return waitClick;
    }
    public WebElement waitSendKeysAndClickByXpath(String locator, String value, String error_message, long timeoutInSeconds){
        WebElement waitClick = waitWithXpath(locator, error_message, timeoutInSeconds);
        waitClick.sendKeys(value);
        return waitClick;
    }

    public WebElement waitAndClickById(String locator, String error_message, long timeoutInSeconds){
        WebElement waitClick = waitWithId(locator,error_message,timeoutInSeconds);
        waitClick.click();
        return waitClick;
    }

    public WebElement waitAndClearById(String locator, String error_message, long timeoutInSeconds){
        WebElement waitClick = waitWithId(locator,error_message,timeoutInSeconds);
        waitClick.clear();
        return waitClick;
    }

    public boolean waitWithIdNotVisable(String locator,String error_message,long timeoutInSeconds){
        By by = this.getLocatorString(locator);
        WebDriverWait wait =  new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void swipeUp(int timeOfSwipe){

        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize(); //getting size of screen
        final int  x = size.width / 2; // coordinate x is constant
        int start_y = (int) (size.height * 0.9);
        int end_y = (int) (size.height * 0.1);

        action.press(x,start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();


    }

    public void swipeUpQuick(){
        swipeUp(2000);
    }

    public void swipeUpToFindElements(String locator, String error_message, int max_swipes){
        By by = this.getLocatorString(locator);
        int done_swipes = 0;
        int counter_of_elements = driver.findElements(by).size(); // this method returns count of found elements

        while(counter_of_elements==0) { // working unless find some element

            if(done_swipes > max_swipes){
                waitWithXpath(locator, "there's error by swiping \n" + error_message,
                        0);
                /*waitWithIdNotVisable(by, "there's error by swiping \n" + error_message,
                        0); // if there's an error exist then error introduced to console*/
                return; // if no error occured then just exit from IF loop
            }
            swipeUpQuick();
            ++done_swipes; // counter_of_elements
        }

    }

    public void swipeAndDeleteToLeft(String locator, String error_message){

        WebElement element = waitWithXpath(locator,
                "No such element presented",
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x+element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;
        TouchAction action = new TouchAction(driver);

        action.
                press(right_x, middle_y).
                waitAction(600).
                moveTo(left_x, middle_y).
                release().
                perform(); // selecting right point, hold and move to the most left point
    }

    public int getAmountOfElements(String locator){
        By by = this.getLocatorString(locator);
        List elements = driver.findElements(by);
        return elements.size(); // returns amount of found elements
    }

    public void assertElementNotPresent(String locator, String error_message){
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements>0){
            String default_message="An element '" + locator + "' supposed not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    public String waitForElementAndGetAtrribute(String locator,String attribute,
                                                 String error_message,
                                                 long timeOutInSeconds){
        WebElement element = waitWithId(locator,error_message,timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    private By getLocatorString(String locator_type){
        String[] exploded_string = locator_type.split(Pattern.quote(":"),2);
        String type = exploded_string[0];
        String element = exploded_string[1];
        if(type.equals("xpath")){
            return By.xpath(element);
        } else if(type.equals("id")){
            return By.id(element);
        } else {
            throw new IllegalArgumentException("Can't get type of locator"+locator_type);
        }
    }


}
