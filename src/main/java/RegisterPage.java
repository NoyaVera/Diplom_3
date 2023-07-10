import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    public void openRegisterPage() {
        driver.get(URL.BASE + URL.REGISTER);
    }

    public void inputName(String text) {
        driver.findElement(nameField).sendKeys(text);
    }

    public void inputEmail(String text) {
        driver.findElement(emailField).sendKeys(text);
    }

    public void inputPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void register(String name, String email, String password) {
        openRegisterPage();
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegisterButton();
    }
}
