package ru.yandex.praktikum.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ClientPageScooter {
    // Переменная для драйвера Selenium-а
    private WebDriver driver;

    // Локатор для поля "Имя"
    private By name = By.xpath(".//input[@placeholder = '* Имя']");

    // Локатор для поля "Фамилия"
    private By lastName = By.xpath(".//input[@placeholder = '* Фамилия']");

    // Локатор для поля "Адрес"
    private By address = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    // Локатор для поля "Телефон"
    private By phoneNumber = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    // Локатор для поля "Станция метро"
    private By metroStation = By.className("select-search__input");

    // Локатор для первой строки выпадающего списка
    private By firstMetroOption = By.xpath(".//li[1]");

    // Локатор для кнопки "Далее"
    private By forwardButton = By.xpath(".//button[text()='Далее']");

    // Конструктор класса
    public ClientPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadPage (){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }

    // Метод вводит данные клиента
    public void inputClientData(String inputName, String inputLastName, String inputAddress, String inputPhoneNumber) {
        driver.findElement(name).sendKeys(inputName);
        driver.findElement(lastName).sendKeys(inputLastName);
        driver.findElement(address).sendKeys(inputAddress);
        driver.findElement(phoneNumber).sendKeys(inputPhoneNumber);
    }

    // Метод заполеняет поле "Станция метро"
    public void inputMetroData(String inputMetroStation) {
        driver.findElement(metroStation).sendKeys(inputMetroStation);
        driver.findElement(firstMetroOption).click();
    }

    // Метод нажимает на кнопку "Далее"
    public void forwardClick() {
        driver.findElement(forwardButton).click();
    }
}
