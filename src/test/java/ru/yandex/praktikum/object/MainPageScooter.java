package ru.yandex.praktikum.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPageScooter {
    // Переменная для драйвера Selenium-а
    private WebDriver driver;

    // Локатор для "стрелочки" раздела "Вопросы о важном"
    private By setArrowNumber(int arrowNumber) {
        return By.xpath(".//div[@class='accordion__item'][" + arrowNumber + "]//div[@class='accordion__button']");
    }

    // Локатор для текста открытой "стрелочки"
    private By setDescriptionNumber(int arrowNumber) {
        return By.xpath(".//div[@class='accordion__item'][" + arrowNumber + "]//div[@class='accordion__panel']/p");
    }

    // Локатор для верхней кнопки "Заказать"
    private By upperOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // Локатор для нижней кнопки "Заказать"
    private By lowerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локатор для кнопки принятия "куков"
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    // Конструктор класса
    public MainPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод скроллит до "стрелочки" раздела "Вопросы о важном"
    public void scrollToArrow(int arrowNumber) {
        WebElement element = driver.findElement(setArrowNumber(arrowNumber));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Метод нажимает на "стрелочку" раздела "Вопросы о важном"
    public void arrowClick(int arrowNumber) {
        driver.findElement(setArrowNumber(arrowNumber)).click();
    }

    // Метод ожидания загрузки текста
    public void waitForLoadDescription (int arrowNumber){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(setDescriptionNumber(arrowNumber)));
    }

    // Метод получения текста
    public String getDescriptionText (int arrowNumber){
        return driver.findElement(setDescriptionNumber(arrowNumber)).getText();
    }

    // Метод нажимает на верхнюю кнопку "Заказать"
    public void upperOrderClick() {
        driver.findElement(upperOrderButton).click();
    }

    // Метод скроллит до "стрелочки" раздела "Вопросы о важном"
    public void scrollToLowerOrder() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Метод нажимает на нижнюю кнопку "Заказать"
    public void lowerOrderClick() {
        driver.findElement(lowerOrderButton).click();
    }

    // Метод нажимает на кнопку принятия "куков"
    public void cookieButtonClick() {
        driver.findElement(cookieButton).click();
    }
}
