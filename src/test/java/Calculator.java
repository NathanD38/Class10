import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calculator extends BasePage {

    private WebDriver driver;

    public Calculator(WebDriver driver) {
        this.driver = driver;
    }

    public void pressButton() {
        clickElement(By.id("three"));
        clickElement(By.id("add"));
        clickElement(By.id("nine"));
        clickElement(By.id("equal"));
    }

    public WebElement getResult() {
        return getElement(By.id("screen"));
    }
}
