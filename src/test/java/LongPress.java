import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPress extends BaseClass{

    @Test
    public void longPressGesture() throws MalformedURLException, InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        // to long press gesture
         longPressAction(ele);

        String menuText = driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());


    }

}
