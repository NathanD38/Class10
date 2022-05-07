import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        driver = DriverSingleton.getDriverInstance();
        driver.get("https://dgotlieb.github.io/WebCalculator/");
    }

    @Test
    public void test_01_printButtonDimensions() {
        System.out.println("Button 7's dimensions are: " + Constants.BUTTON_DIMENSIONS.getSize());
    }

    @Test
    public void test_02_checkIfButtonIsDisplayed() {
        WebElement button6 = driver.findElement(By.id("six"));
        System.out.println("Button 6 is displayed: " + button6.isDisplayed());
    }

    @Test
    public void test_03_mathForumlaCalc() {
        String result = "12";
        int resultCalc = Integer.parseInt(result);
        System.out.println(resultCalc);
        Calculator calculator = new Calculator(driver);
        calculator.pressButton();
        String screenResult = calculator.getResult().getText();
        int actualResult = Integer.parseInt(screenResult);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, resultCalc);

    }

    @AfterClass
    public static void tearDown() {
        // driver.quit();
    }

}
