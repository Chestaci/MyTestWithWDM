package com.github.Chestaci.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Объект страницы Your Cart
 */
public class CartPage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля кнопки добавления продукта
     */
    @FindBy(xpath = "//*[@id=\"checkout\"]")
    private WebElement checkoutButton;

    /**
     * метод для осуществления нажатия кнопки checkout
     * @return возвращает страницу CheckoutOnePage
     * @see CheckoutOnePage
     */
    @Step("Нажатие на кнопку checkout на странице корзины")
    public CheckoutOnePage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutOnePage(this.driver);
    }
}
