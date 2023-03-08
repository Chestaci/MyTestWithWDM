package com.github.Chestaci.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Объект страницы Checkout: Overview
 */
public class CheckoutTwoPage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public CheckoutTwoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля кнопки finish
     */
    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement finishButton;

    /**
     * метод для осуществления нажатия кнопки finish
     * @return возвращает страницу CompletePage
     * @see CompletePage
     */
    @Step("Нажатие на кнопку finish на странице CHECKOUT: OVERVIEW")
    public CompletePage clickFinishButton() {
        finishButton.click();
        return new CompletePage(this.driver);
    }
}
