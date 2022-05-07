import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


//2 - Using ngWebDriver to interact with an AngularKS-based webpage.
public class AngularTest {

    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.get("https://dgotlieb.github.io/AngularJS/main.html");
    }

    @Test
    public void test_01_findAngularElement() {
        WebElement firstName = driver.findElement(ByAngular.model("firstName"));
        String result = firstName.getAttribute("value");
        System.out.println("name is: " + result);
        firstName.clear();
        firstName.sendKeys("Netanel");
        String newName = "Netanel";
        String result1 = firstName.getAttribute("value");
        System.out.println("new name is: " + result1);
        Assert.assertEquals(result1, newName);
    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }

    //3 - PageLoadTimeOut is used for limiting the time that the script allots for a webpage to completely load.
    // If it loads within that time, then the script continues. If it doesn't, then the script throws a TimeoutException.

}
