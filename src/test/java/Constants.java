import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Constants {
    public static final String CHROMEDRIVER_PATH = "src/test/java/drivers/chromedriver.exe";
    public static final WebElement BUTTON_DIMENSIONS = DriverSingleton.getDriverInstance().findElement(By.id("seven"));
}
