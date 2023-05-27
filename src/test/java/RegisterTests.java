import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTests {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void registerTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        registerPage.inputName("John");
        registerPage.inputEmail("930384@gmail.com");
        registerPage.inputPassword("098765");
        registerPage.clickRegisterButton();
        Assert.assertEquals("Вход", authorizationPage.getTitleText());
    }

    @Test
    @DisplayName("Попытка регистрации с коротким паролем(<6)")
    public void passwordErrorTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register("John", "930384@gmail.com", "12345");
        Assert.assertEquals("Некорректный пароль", registerPage.getPasswordErrorText());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
