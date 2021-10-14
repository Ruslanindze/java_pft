package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupHelper {
    private FirefoxDriver driver;

    public GroupHelper(FirefoxDriver driver) {
        this.driver = driver;
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

    public void deleteSelectedGroups() {
        WebElement buttonDeleteGroup = driver.findElement(By.xpath("//input[@name='delete']"));
        buttonDeleteGroup.click();
    }

    public void selectGroup() {
        WebElement selectGroup = driver.findElement(By.xpath("//input[@name='selected[]']"));
        selectGroup.click();
    }
}
