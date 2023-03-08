package com.github.Chestaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public abstract class MyTest {
    public static WebDriver driver;

    /**
     * Осуществление общей подготовительной настройки
     */
    @BeforeAll
    @Step("Подготовительные действия перед началом тестов. Инициализация WebDriver.")
    public static void setupAll() {
        //Инициализация менеджера WebDrivers
        WebDriverManager.chromedriver().setup();
    }
}
