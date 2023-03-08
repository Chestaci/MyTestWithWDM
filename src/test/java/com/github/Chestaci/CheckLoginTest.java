package com.github.Chestaci;

import com.github.Chestaci.pages.MainPage;
import com.github.Chestaci.utils.ConfProperties;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Тесты главной страницы")
@Feature("Тест авторизации")
public class CheckLoginTest extends MyTest {
    private MainPage mainPage;

    /**
     * осуществление первоначальной настройки
     */
    @BeforeEach
    @Step("Настройки перед началом тестов. Создание начальной страницы и ее открытие.")
    public void setup() {
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //инициализация начальной страницы
        mainPage = new MainPage(driver);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("main_page"));
    }

    /**
     * тестовый метод для осуществления проверки сообщения об ошибке при
     * попытке ввода логина на несуществующего пользователя
     */
    @Test
    @DisplayName("Проверка ошибки авторизации")
    @Description("Тест для осуществления проверки сообщения об ошибке" +
            " при попытке ввода логина на несуществующего пользователя")
    @Story("Тест аторизации с неверными данными")
    public void checkLoginTest() {
        mainPage.signIn(
                ConfProperties.getProperty("username1"),
                ConfProperties.getProperty("password1")
        );

        String errorField = mainPage.getErrorField();
        Assertions.assertTrue(errorField.toUpperCase().contains(ConfProperties.getProperty("message1").toUpperCase()));
    }

    /**
     * Закрытие окна браузера
     */
    @AfterEach
    @Step("Окончательные завершающие действия после завершения тестов. Закрытие браузера.")
    public void tearDown() {
        driver.quit();
    }
}
