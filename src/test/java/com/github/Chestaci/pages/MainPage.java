package com.github.Chestaci.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Объект страницы Main (https://www.saucedemo.com/)
 */
public class MainPage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода username
     */
    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement usernameField;

    /**
     * определение локатора поля ввода password
     */
    @FindBy(id = "password")
    private WebElement passwordField;

    /**
     * определение локатора поля кнопки входа в аккаунт
     */
    @FindBy(css = "#login-button")
    private WebElement loginButton;

    /**
     * определение локатора текста сообщения об ошибке при
     * попытке ввода логина на несуществующего
     * пользователя
     */
    @FindBy(xpath = "/html/body/div/div/div[2]/div[1]/div[1]/div/form/div[3]/h3")
    private WebElement errorField;

    /**
     * метод для ввода
     * @param username - имя пользователя
     */
    @Step("Заполнение поля username: {username} на странице входа: https://www.saucedemo.com/")
    private void inputUsername(String username) {
        usernameField.sendKeys(username);
    }

    /**
     * метод для ввода
     * @param password - пароль пользователя
     */
    @Step("Заполнение поля password: {password} на странице входа: https://www.saucedemo.com/")
    private void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     * @return страницу ProductsPage
     * @see ProductsPage
     */
    @Step("Нажатие на кнопку login на странице входа: https://www.saucedemo.com/")
    private ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(this.driver);
    }

    /**
     * метод для осуществления получения текста сообщения об ошибке при
     * попытке ввода логина на несуществующего пользователя
     * @return возвращает сообщение об ошибке
     */
    @Step("Получение сообщения об ошибке на странице входа: https://www.saucedemo.com/")
    @Attachment
    public String getErrorField() {
        return errorField.getText();
    }

    /**
     * метод для осуществления авторизации пользователя на сайте.
     * Заполняются поля
     * @param username - имя пользователя
     * @param password - пароль пользователя
     * @return страницу ProductsPage
     * @see ProductsPage
     */
    @Step("Авторизация пользователя по username: {username} и password: {password}" +
            " на странице входа: https://www.saucedemo.com/")
    public ProductsPage signIn(String username, String password){
        inputUsername(username);
        inputPassword(password);
        return clickLoginButton();
    }
}
