package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class Platform {

    private static Platform instance;

    private Platform(){}

    public static Platform getInstance(){
        if(instance == null){
            instance = new Platform();
        }
        return instance;
    }

    private static final String
            PLATFORM_ANDROID = "android",
            PLATFORM_IOS = "ios";

    private static final String
            //AppiumURLLocal="https://us1.appium.testobject.com/wd/hub",
            AppiumURLLocal="http://127.0.0.1:4723/wd/hub",
            AppiumURLRemote="http://192.168.99.101:4723/wd/hub",
            AppiumSauceLabURL = "https://us1.appium.testobject.com/wd/hub";

    public AppiumDriver getDriver() throws Exception {
        URL URL = new URL(AppiumURLLocal);
        if(this.isAndroid()){
            return new AndroidDriver(URL,this.getAndroidDesiredCapabilities());
        } else if(this.isIOS()){
            return new AndroidDriver(URL, this.getIOSDesiredCapabilities());
        } else {
            throw new Exception("Can't get Appium Driver" + this.getPlatform());
        }
    }


    public boolean isAndroid(){
        return this.isPlatform(PLATFORM_ANDROID);
    }

    public boolean isIOS(){
        return this.isPlatform(PLATFORM_IOS);
    }

    private DesiredCapabilities getAndroidDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.1.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity","org.wikipedia.main.MainActivity");
        capabilities.setCapability("app","C:/JavaAppiumAutomation/firstTestProject/apk/org.wikipedia.apk");
        return capabilities;
    }

    private DesiredCapabilities getIOSDesiredCapabilities(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("deviceName","iPhone SE");
        capabilities.setCapability("platformVersion","12.1");
        capabilities.setCapability("app","/Users/qa/Desktop/Wikipedia.app");
        return capabilities;
    }

    private boolean isPlatform(String platform){
        String getMyPlatform = this.getPlatform();
        return platform.equals(getMyPlatform);
    }

    private String getPlatform(){
        return System.getenv("PLATFORM");
    }
}
