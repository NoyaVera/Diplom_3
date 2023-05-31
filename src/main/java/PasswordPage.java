import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordPage {
    private final WebDriver driver;
    private final By authorizationPasswordPage = By.xpath(".//a[text()='Войти']");

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPasswordPage() {
        driver.get(URL.BASE + URL.PASSWORD);
    }

    public void clickAuthorizationPasswordPage() {
        driver.findElement(authorizationPasswordPage).click();
    }
}
