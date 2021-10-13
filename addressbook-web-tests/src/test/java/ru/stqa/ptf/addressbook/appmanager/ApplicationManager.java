package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ConfProperties;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver driver;

    public void init() {
        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("firefoxDriver"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginPage"));
        login();
    }

    private void login() {
        WebElement loginName = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='user']"));
        loginName.clear();
        loginName.sendKeys(ConfProperties.getProperty("login"));
        WebElement loginPassword = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='pass']"));
        loginPassword.clear();
        loginPassword.sendKeys(ConfProperties.getProperty("password"));
        WebElement buttonInput = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@value='Login']"));
        buttonInput.click();
    }

    public void gotoGroupPage() {
        WebElement buttonGroups = driver.findElement(By.xpath("//div[@id='nav']/ul/li[@class='admin']"));
        buttonGroups.click();
    }

    public void initGroupCreation() {
        WebElement buttonNewGroup = driver.findElement(By.xpath("//input[@name='new'][1]"));
        buttonNewGroup.click();
    }

    public void fillGroupForm(GroupData groupData) {
        WebElement fieldGroupName = driver.findElement(By.xpath("//input[@name='group_name']"));
        fieldGroupName.click();
        fieldGroupName.sendKeys(groupData.getName());

        WebElement fieldGroupHeader = driver.findElement(By.xpath("//textarea[@name='group_header']"));
        fieldGroupHeader.sendKeys(groupData.getHeader());

        WebElement fieldFooter = driver.findElement(By.xpath("//textarea[@name='group_footer']"));
        fieldFooter.sendKeys(groupData.getFooter());
    }

    public void submitGroupCreation() {
        WebElement buttonEnterInfo = driver.findElement(By.xpath("//input[@name='submit']"));
        buttonEnterInfo.click();
    }

    public void returnToGroupPage() {
        WebElement linkReturnGroupPage = driver.findElement(By.xpath("//div[@class='msgbox']//a"));
        linkReturnGroupPage.click();
    }

    public void stop() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        driver.quit();
    }

    public void deleteSelectedGroups() {
        WebElement buttonDeleteGroup = driver.findElement(By.xpath("//input[@name='delete']"));
        buttonDeleteGroup.click();
    }

    public void selectGroup() {
        WebElement selectGroup = driver.findElement(By.xpath("//input[@name='selected[]']"));
        selectGroup.click();
    }
}
