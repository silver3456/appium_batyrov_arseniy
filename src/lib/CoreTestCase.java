package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;


public class CoreTestCase extends TestCase {
    protected AppiumDriver driver;



    @Override //overload setUp of Super class TestCase
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown(); //inherit method from TestCase
        driver.quit();
    }

    protected void rotateScreenLandscape(){
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void rotateScreenPortrait(){
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void runInBackground(int sec){
        driver.runAppInBackground(10);
        //driver.runAppInBackground(Duration.ofSeconds(10));
    }

}
