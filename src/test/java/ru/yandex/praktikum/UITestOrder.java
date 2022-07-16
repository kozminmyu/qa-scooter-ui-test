package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.object.ClientPageScooter;
import ru.yandex.praktikum.object.MainPageScooter;
import ru.yandex.praktikum.object.RentPageScooter;

// Параметризованный класс для проверки создания заказа
@RunWith(Parameterized.class)
public class UITestOrder {
    private WebDriver driver;

    private final String name;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String metro;
    private final String date;
    private final int durationOption;
    private final String colorOption;
    private final String comment;

    public UITestOrder(String name, String lastName, String address, String phone, String metro, String date, int durationOption, String colorOption, String comment) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.metro = metro;
        this.date = date;
        this.durationOption = durationOption;
        this.colorOption = colorOption;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDescriptions() {
        return new Object[][] {
                {"Иван", "Иванов", "Улица Ленина, д. 1, кв. 1", "+79112223344", "Арбатская", "01.01.2001", 1, "black", "ghsdghsdhh"},
                {"Петр", "Петров", "Улица Сталина, д. 12, кв. 12", "+79223334455", "Пушкинская", "02.02.2002", 2, "grey", "овпваар"}
        };
    }

    // Проверка заказа через верхнюю кнопку "Заказать" в Chrome
    @Test
    public void upperOrderTestChrome() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Нажатие на верхнюю кнопку "Заказать"
        objMainPage.upperOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    // Проверка заказа через нижнюю кнопку "Заказать" в Chrome
    @Test
    public void lowerOrderTestChrome() {
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Скроллим до нижней кнопки "Заказать"
        objMainPage.scrollToLowerOrder();

        // Нажатие на нижнюю кнопку "Заказать"
        objMainPage.lowerOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    // Проверка заказа через верхнюю кнопку "Заказать" в Firefox
    @Test
    public void upperOrderTestFirefox() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Нажатие на верхнюю кнопку "Заказать"
        objMainPage.upperOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    // Проверка заказа через нижнюю кнопку "Заказать" в Firefox
    @Test
    public void lowerOrderTestFirefox() {
        driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Создание объекта класса главной страницы
        MainPageScooter objMainPage = new MainPageScooter(driver);

        // Принимаем куки, чтобы панель не мешала
        objMainPage.cookieButtonClick();

        // Скроллим до нижней кнопки "Заказать"
        objMainPage.scrollToLowerOrder();

        // Нажатие на нижнюю кнопку "Заказать"
        objMainPage.lowerOrderClick();

        // Создание объекта класса заполнение деталей клиента
        ClientPageScooter objClientPage = new ClientPageScooter(driver);

        // Ожидание загрузки страницы
        objClientPage.waitForLoadPage();

        // Заполняем поля данных клиента
        objClientPage.inputClientData(name, lastName, address, phone);

        // Заполняем поле "Станция метро"
        objClientPage.inputMetroData(metro);

        // Нажимаем кнопку "Далее"
        objClientPage.forwardClick();

        // Создание объекта класса заполнение деталей заказа
        RentPageScooter objRentPage = new RentPageScooter(driver);

        // Ожидание загрузки страницы
        objRentPage.waitForLoadPage();

        // Заполняем поля даты и длительности
        objRentPage.inputOrderData(date, comment);

        // Заполняем поле "Длительность"
        objRentPage.chooseDuration(durationOption);

        // Заполняем поле "Цвет самоката"
        objRentPage.chooseColor(colorOption);

        // Нажимаем кнопку "Заказать"
        objRentPage.orderClick();

        // Ожидание загрузки окна подтверждения заказа
        objRentPage.waitForConfirm();

        // Нажимаем кнопку "Да"
        objRentPage.yesClick();

        // Ожидаем загрузки окна завершения заказа
        objRentPage.waitForFinish();
    }

    @After
    public void closeBrowser() {
        // Метод закрывает браузер
        driver.quit();
    }
}
