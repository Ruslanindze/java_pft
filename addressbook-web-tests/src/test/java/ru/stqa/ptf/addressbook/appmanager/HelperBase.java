package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
    protected FirefoxDriver driver;

    public HelperBase(FirefoxDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        WebElement field = driver.findElement(locator);
        field.click();
        field.clear();
        field.sendKeys(text);
    }

    protected void select(By locator, String text) {
        WebElement selectElem = driver.findElement(locator);
        Select select = new Select(selectElem);
        select.selectByVisibleText(text);
    }

    protected void click(By locator) {
        WebElement buttonEnterInfo = driver.findElement(locator);
        buttonEnterInfo.click();
    }

    public boolean isAlertPresent () {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
