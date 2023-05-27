import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthorizationPage {
    private final WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By entranceText = By.xpath(".//h2[text()='Вход']");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");

    public void openAuthorizationPage() {
        driver.get(URL.BASE + URL.AUTHORIZATION);
    }

    public String getTitleText() {
        return driver.findElement(entranceText).getText();
    }

    public void inputEmail(String text) {
        driver.findElement(emailField).sendKeys(text);
    }

    public void inputPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void authorization(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickSignInButton();
    }

    public boolean availableRestorePassword() {
        return driver.findElement(restorePasswordButton).isDisplayed();
    }
}
