package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ConfProperties;

public class SessionHelper {

    private FirefoxDriver driver;

    public SessionHelper(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void login() {
        WebElement loginName = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='user']"));
        loginName.clear();
        loginName.sendKeys(ConfProperties.getProperty("login"));
        WebElement loginPassword = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@name='pass']"));
        loginPassword.clear();
        loginPassword.sendKeys(ConfProperties.getProperty("password"));
        WebElement buttonInput = driver.findElement(By.xpath("//form[@id='LoginForm']/input[@value='Login']"));
        buttonInput.click();
    }
}
