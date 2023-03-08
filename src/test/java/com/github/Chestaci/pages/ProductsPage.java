package com.github.Chestaci.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Объект страницы Products
 */
public class ProductsPage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля кнопок добавления всех продуктов
     */
    @FindBy(xpath = "//*[contains(text(), 'Add to cart')]")
    private List<WebElement> addToCartButtonList;

    /**
     * определение локатора поля кнопки перехода в корзину
     */
    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    /**
     * метод для осуществления нажатия кнопки добавления продукта в корзину
     * @param number - порядковый номер продукта на странице в диапазоне
     *               от 1 до addToCartButtonList.size()
     * @throws ArrayIndexOutOfBoundsException бросает ошибку если
     *              не правильный number, 0 или больше чем addToCartButtonList.size()
     */
    @Step("Нажатие на кнопку add to cart элемента № number {number} на странице PRODUCTS")
    public void addItemToCart(int number) throws ArrayIndexOutOfBoundsException{
        addToCartButtonList.get(number-1).click();
    }

    /**
     * метод для осуществления нажатия кнопки перехода в корзину
     * @return возвращает страницу CartPage
     * @see CartPage
     */
    @Step("Нажатие на кнопку cart на странице PRODUCTS")
    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(this.driver);
    }
}
