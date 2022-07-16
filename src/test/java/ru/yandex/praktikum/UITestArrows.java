package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.object.MainPageScooter;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

// Параметризованный класс для проверки "стрелочек"
@RunWith(Parameterized.class)
public class UITestArrows {
    private WebDriver driver;

    private final String expectedDescription;
    private final int arrowNumber;

    public UITestArrows(int arrowNumber, String expectedDescription) {
        this.arrowNumber = arrowNumber;
        this.expectedDescription = expectedDescription;
    }

    @Parameterized.Parameters
    public static Object[][] getDescriptions() {
        return new Object[][] {
                { 1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                { 2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                { 3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                { 4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                { 5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                { 6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                { 7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                { 8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    // Проверка "стрелочек" в Chrome
    @Test
    public void arrowTestChrome() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Скролл до "стрелочек"
        objMainPage.scrollToArrow(arrowNumber);
        // Нажатие на "стрелочку"
        objMainPage.arrowClick(arrowNumber);
        // Ожидание открытия "стрелочки"
        objMainPage.waitForLoadDescription(arrowNumber);
        // Получение текста
        String actualDescription = objMainPage.getDescriptionText(arrowNumber);

        // Сравнение результатов
        assertEquals("Текст должен соответствовать ожидаемому", expectedDescription, actualDescription);
    }

    // Проверка "стрелочек" в Firefox
    @Test
    public void arrowTestFirefox() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Скролл до "стрелочек"
        objMainPage.scrollToArrow(arrowNumber);
        // Нажатие на "стрелочку"
        objMainPage.arrowClick(arrowNumber);
        // Ожидание открытия "стрелочки"
        objMainPage.waitForLoadDescription(arrowNumber);
        // Получение текста
        String actualDescription = objMainPage.getDescriptionText(arrowNumber);

        // Сравнение результатов
        assertEquals("Текст должен соответствовать ожидаемому", expectedDescription, actualDescription);
    }

    @After
    public void closeBrowser() {
        // Метод закрывает браузер
        driver.quit();
    }

}
