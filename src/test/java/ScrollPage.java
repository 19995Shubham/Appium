import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollPage extends BaseClass {

    @Test
    public void scrollPageTest(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        // Where to scroll known prior
        driver.findElement(AppiumBy.
                androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        // Scroll a little or to the co-ordinate, No prior knowledge how longer to scroll
        canScrollMoreAction();

    }
}