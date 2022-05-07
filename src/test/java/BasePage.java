import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebElement getElement(By locator) {
        return getWebElement(locator);
    }

    public void clickElement (By locator) {
        getWebElement(locator).click();
    }

    private WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
    }
}
