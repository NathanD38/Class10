import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitingTest extends BasePage {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //for implicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // for explicit wait
        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    }

    @Test
    public void test_01_implicitWait() {
        clickElement(By.id("btn"));
        getElement(By.id("message"));
    }

    @Test
    public void test_02_unconditionalWait() throws InterruptedException {
        clickElement(By.id("hidden"));
        Thread.sleep(3000); // for unconditional wait
        getElement(By.id("finish1"));
    }

    @Test
    public void test_03_explicitWait() {
        clickElement(By.id("rendered"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
    }


    @AfterClass
    public static void tearDown() {
//        driver.quit();
    }
}
