package ru.yandex.praktikum.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class RentPageScooter {
    // Переменная для драйвера Selenium-а
    private WebDriver driver;

    // Локатор для поля "Когда привезти самокат"
    private By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Локатор для поля "Срок аренды"
    private By duration = By.className("Dropdown-placeholder");

    // Локатор для выбора из выпадающего списка
    private By setDuration(int durationOptionNumber) {
        return By.xpath(".//div[@class='Dropdown-option'][" + durationOptionNumber + "]");
    }

    // Локатор для выбора цвета (black или grey)
    private By setColor(String colorOption) {
        return By.xpath(".//input[@id='" + colorOption + "']");
    }

    // Локатор для поля "Комментарий"
    private By comment = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Локатор для кнопки "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Локатор для кнопки "Да"
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // Конструктор класса
    public RentPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadPage (){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
    }

    // Метод вводит дату и комментарий
    public void inputOrderData(String inputDate, String inputComment) {
        driver.findElement(date).sendKeys(inputDate);
        driver.findElement(date).sendKeys(Keys.RETURN);
        driver.findElement(comment).sendKeys(inputComment);
    }

    // Метод заполеняет поле "Срок аренды"
    public void chooseDuration(int durationOptionNumber) {
        driver.findElement(duration).click();
        driver.findElement(setDuration(durationOptionNumber)).click();
    }

    // Метод заполеняет поле "Цвет самоката"
    public void chooseColor(String colorOption) {
        driver.findElement(setColor(colorOption)).click();
    }

    // Метод нажимает на кнопку "Далее"
    public void orderClick() {
        driver.findElement(orderButton).click();
    }

    // Ожидание открытия окна подтверждения заказа
    public void waitForConfirm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
    }

    // Метод нажимает на кнопку "Да"
    public void yesClick() {
        driver.findElement(yesButton).click();
    }

    // Ожидание открытия окна подтверждения заказа
    public void waitForFinish() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[text()='Посмотреть статус']")));
    }
}
