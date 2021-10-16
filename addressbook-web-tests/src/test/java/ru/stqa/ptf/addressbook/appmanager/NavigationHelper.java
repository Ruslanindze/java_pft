package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void gotoGroupPage() {
        click(By.xpath("//div[@id='nav']/ul/li[@class='admin']"));
    }

    public void gotoAddContact() {
        click(By.xpath("//div[@id='nav']/ul/li[@class='all'][1]"));
    }
}