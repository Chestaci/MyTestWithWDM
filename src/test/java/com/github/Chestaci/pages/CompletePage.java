package com.github.Chestaci.pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Объект страницы Checkout: Complete!
 */
public class CompletePage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public CompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора текста сообщения о результате
     */
    @FindBy(xpath = "/html/body/div/div/div/div[2]/h2")
    private WebElement completeField;

    /**
     * определение локатора поля меню с кнопками
     */
    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement menuButton;

    /**
     * определение локатора поля кнопки logout
     */
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutButton;

    /**
     * метод для осуществления нажатия кнопки меню
     */
    @Step("Нажатие на кнопку menu на странице завершения покупки")
    public void clickMenuButton() {
        menuButton.click();
    }

    /**
     * метод для осуществления нажатия кнопки logout
     * @return возвращает страницу MainPage
     * @see MainPage
     */
    @Step("Нажатие на кнопку logout на странице завершения покупки")
    public MainPage clickLogoutButton() {
        logoutButton.click();
        return new MainPage(this.driver);
    }

    /**
     * метод для осуществления получения текста сообщения о результате
     * @return возвращает сообщение о результате завершения покупки
     */
    @Step("Получение сообщения о результате на странице завершения покупки")
    @Attachment
    public String getCompleteField() {
        return completeField.getText();
    }
}
