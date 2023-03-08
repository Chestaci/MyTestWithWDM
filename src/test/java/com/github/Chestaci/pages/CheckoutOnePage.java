package com.github.Chestaci.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Объект страницы Checkout: Your Information
 */
public class CheckoutOnePage {

    private final WebDriver driver;

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public CheckoutOnePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора поля ввода first name
     */
    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement firstNameField;

    /**
     * определение локатора поля ввода last name
     */
    @FindBy(css = "#last-name")
    private WebElement lastNameField;

    /**
     * определение локатора поля ввода postal code
     */
    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    /**
     * определение локатора поля кнопки continue
     */
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueButton;

    /**
     * метод для ввода
     * @param firstName Имя
     */
    @Step("Заполнение поля firstName: {firstName} на странице CHECKOUT: YOUR INFORMATION")
    private void inputFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    /**
     * метод для ввода
     * @param lastName Фамилия
     */
    @Step("Заполнение поля lastName: {lastName} на странице CHECKOUT: YOUR INFORMATION")
    private void inputLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    /**
     * метод для ввода
     * @param postalCode (ZipCode или PostalCode) адрес доставки
     */
    @Step("Заполнение поля postalCode: {postalCode} на странице CHECKOUT: YOUR INFORMATION")
    private void inputPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    /**
     * метод для осуществления нажатия кнопки continue
     * @return возвращает страницу CheckoutTwoPage
     * @see CheckoutTwoPage
     */
    @Step("Нажатие на кнопку continue на странице CHECKOUT: YOUR INFORMATION")
    private CheckoutTwoPage clickContinueButton() {
        continueButton.click();
        return new CheckoutTwoPage(this.driver);
    }

    /**
     * метод для осуществляющий действия по заполнению полей формы параметрами
     * @param firstName Имя
     * @param lastName Фамилия
     * @param postalCode (ZipCode или PostalCode) адрес доставки,
     * а также нажатие кнопки continue
     * @return возвращает страницу CheckoutTwoPage
     * @see CheckoutTwoPage
     */
    @Step("Заполнение полей firstName: {firstName}, lastName: {lastName}, postalCode: {postalCode}" +
            " и нажатие кнопки continue на странице CHECKOUT: YOUR INFORMATION")
    public CheckoutTwoPage checkout(String firstName, String lastName, String postalCode){
        inputFirstName(firstName);
        inputLastName(lastName);
        inputPostalCode(postalCode);
        return clickContinueButton();
    }
}
