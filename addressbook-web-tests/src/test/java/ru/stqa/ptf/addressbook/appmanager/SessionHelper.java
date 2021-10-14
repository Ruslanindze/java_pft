package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ConfProperties;

public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void login() {
        type(By.xpath("//form[@id='LoginForm']/input[@name='user']"), ConfProperties.getProperty("login"));
        type(By.xpath("//form[@id='LoginForm']/input[@name='pass']"), ConfProperties.getProperty("password"));
        click(By.xpath("//form[@id='LoginForm']/input[@value='Login']"));
    }
}
