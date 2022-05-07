import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ChallengesTest {

    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
        driver.get("https://www.google.com");
    }

    @Test
    public void test_01_openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.youtube.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://translate.google.com");
        ArrayList<String> openedTabs = new ArrayList<>(driver.getWindowHandles());
        for (String handle : openedTabs) {
            driver.switchTo().window(handle);
            if ("Google".equals(driver.getTitle())) {
                break;
            }
        }
    }


    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }

}
