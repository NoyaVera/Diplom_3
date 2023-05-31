import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OutProfileTests {
    WebDriver driver;
    private final String email = "Uchkuduk@yandex.ru";
    private final String password = "123456";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Выход из аккаунта в личном кабинете")
    public void profileTest() {
        MainPage mainPage = new MainPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        mainPage.openMainPage();
        mainPage.clickSignInButton();
        authorizationPage.authorization(email, password);
        mainPage.openMainPage();
        mainPage.clickProfileButton();
        profilePage.clickLogOutButton();
        Assert.assertTrue(authorizationPage.availableRestorePassword());
    }

    @After
    public void tearsDown() {
        driver.quit();
    }
}
