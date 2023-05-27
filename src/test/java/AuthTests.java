import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class AuthTests {
    WebDriver driver;
    private final String email = "Uchkuduk@yandex.ru";
    private final String password = "123456";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Авторизация по кнопке 'войти в аккаунт' на главной странице")
    public void authMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        authorizationPage.authorization(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация через страницу регистрации")
    public void authRegisterPageTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openRegisterPage();
        registerPage.clickSignInButton();
        authorizationPage.authorization(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация по кнопке `личный кабинет` на главной странице")
    public void authProfileButtonTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        authorizationPage.authorization(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @Test
    @DisplayName("Авторизация через страницу восстановления пароля")
    public void authRecoveryPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.openPasswordPage();
        passwordPage.clickAuthorizationPasswordPage();
        authorizationPage.authorization(email, password);
        assertTrue(mainPage.orderListAvailable());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}

