import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileTests {
    WebDriver driver;
    private final String name = "Ray";
    private final String email = "Uchkuduk@yandex.ru";
    private final String password = "123456";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.register(name, email, password);
    }

    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void profileTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        authorizationPage.openAuthorizationPage();
        authorizationPage.authorization(email, password);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        Assert.assertTrue(profilePage.availableProfileButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета к конструктору")
    public void profileToConstructorTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        authorizationPage.openAuthorizationPage();
        authorizationPage.authorization(email, password);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.availableOrderButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета к конструктору по клику на логотип")
    public void profileToConstructorLogoTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        authorizationPage.openAuthorizationPage();
        authorizationPage.authorization(email, password);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.availableOrderButton());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
