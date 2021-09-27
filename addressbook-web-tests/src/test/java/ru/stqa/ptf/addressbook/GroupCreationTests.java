package ru.stqa.ptf.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class GroupCreationTests {
    FirefoxDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("firefoxDriver"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void groupCreationTests() {
        // STEP 1. Открываем сайт
        driver.get(ConfProperties.getProperty("loginPage"));

        // STEP 2. Логинимся
        WebElement loginName = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='user']"));
        loginName.clear();
        loginName.sendKeys(ConfProperties.getProperty("login"));

        WebElement loginPassword = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='pass']"));
        loginPassword.clear();
        loginPassword.sendKeys(ConfProperties.getProperty("password"));

        WebElement buttonInput = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@value='Login']"));
        buttonInput.click();

        // STEP 3. Проверяем пользователя.
        String nameUser = driver.findElement(By.xpath("//form[@name='logout']/b")).getText();
        Assert.assertTrue(nameUser.contains(ConfProperties.getProperty("login")), "Логин прошёл успешно.");

        // STEP 4. Переходим в меню groups через нажатие кнопки и проверяем url.
        WebElement buttonGroups = driver.findElement(By.xpath("//div[@id='nav']/ul/li[@class='admin']"));
        buttonGroups.click();
        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("groupsPage"));

        // STEP 5. Создаём группу с произвольными данными.
        WebElement buttonNewGroup = driver.findElement(By.xpath("//input[@name='new'][1]"));
        buttonNewGroup.click();

        WebElement fieldGroupName = driver.findElement(By.xpath("//input[@name='group_name']"));
        fieldGroupName.click();
        fieldGroupName.sendKeys("Джуны Сопрано");

        WebElement fieldGroupHeader = driver.findElement(By.xpath("//textarea[@name='group_header']"));
        fieldGroupHeader.sendKeys("Сопрано рулят!");

        WebElement fieldFooter = driver.findElement(By.xpath("//textarea[@name='group_footer']"));
        fieldFooter.sendKeys("Тут наша кухня. Берегитесь семьи Сопаретто!!!");

        WebElement buttonEnterInfo = driver.findElement(By.xpath("//input[@name='submit']"));
        buttonEnterInfo.click();

        // STEP 6. Возвращаемся в список групп и проверяем созданную группу.
        WebElement linkReturnGroupPage = driver.findElement(By.xpath("//div[@class='msgbox']//a"));
        linkReturnGroupPage.click();
        ArrayList<WebElement> groups = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='content']//span"));

//        for (WebElement group: groups) {
//
//        }
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        driver.quit();
    }
}