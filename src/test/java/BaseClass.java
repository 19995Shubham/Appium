import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {

    public AndroidDriver driver;

    @BeforeClass()
    public void configureAppium() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName("Pixel 4 API 32");
        options.setApp("C://Users//ShubhamT.INTERRAIT//IdeaProjects//Appium//src//test//java//resources//ApiDemos.apk");
        options.setPlatformName("android");


//        Launch the mobile browser
//        options.withBrowserName("Chrome");

        // Create an AndroidDriver instance
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void longPressAction(WebElement ele){
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }

    public void  canScrollMoreAction(){
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0));
        }
        while(canScrollMore);
    }

    public void swipeAction(WebElement ele, String direction){

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));
    }

    @AfterClass()
    public void tearDown(){
        driver.quit();
    }

}
