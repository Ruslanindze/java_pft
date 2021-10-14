package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void initGroupCreation() {
        click(By.xpath("//input[@name='new'][1]"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.xpath("//input[@name='group_name']"), groupData.getName());

        type(By.xpath("//textarea[@name='group_header']"), groupData.getHeader());

        type(By.xpath("//textarea[@name='group_footer']"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.xpath("//input[@name='submit']"));
    }

    public void returnToGroupPage() {
        click(By.xpath("//div[@class='msgbox']//a"));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("//input[@name='delete']"));
    }

    public void selectGroup() {
        click(By.xpath("//input[@name='selected[]']"));
    }
}
