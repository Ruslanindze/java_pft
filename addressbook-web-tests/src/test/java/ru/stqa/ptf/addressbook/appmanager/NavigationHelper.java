package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    private FirefoxDriver driver;

    public NavigationHelper(FirefoxDriver driver) {
        this.driver = driver;
    }

    public void gotoGroupPage() {
        WebElement buttonGroups = driver.findElement(By.xpath("//div[@id='nav']/ul/li[@class='admin']"));
        buttonGroups.click();
    }
}
