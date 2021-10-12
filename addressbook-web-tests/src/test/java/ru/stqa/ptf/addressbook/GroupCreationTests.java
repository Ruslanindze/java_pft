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

        String nameUser = driver.findElement(By.xpath("//form[@name='logout']/b")).getText();
        Assert.assertTrue(nameUser.contains(ConfProperties.getProperty("login")), "Логин прошёл успешно.");
    }

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("June Sopranos", "The Sopranos rule!", "This is our kitchen. Watch out for the Soparetto family !!!"));
        submitGroupCreation();
        returnToGroupPage("June Sopranos");
    }

    private void gotoGroupPage() {
        WebElement buttonGroups = driver.findElement(By.xpath("//div[@id='nav']/ul/li[@class='admin']"));
        buttonGroups.click();
        Assert.assertEquals(driver.getCurrentUrl(), ConfProperties.getProperty("groupsPage"));
    }

    private void initGroupCreation() {
        WebElement buttonNewGroup = driver.findElement(By.xpath("//input[@name='new'][1]"));
        buttonNewGroup.click();
    }

    private void fillGroupForm(GroupData groupData) {
        WebElement fieldGroupName = driver.findElement(By.xpath("//input[@name='group_name']"));
        fieldGroupName.click();
        fieldGroupName.sendKeys(groupData.getName());

        WebElement fieldGroupHeader = driver.findElement(By.xpath("//textarea[@name='group_header']"));
        fieldGroupHeader.sendKeys(groupData.getHeader());

        WebElement fieldFooter = driver.findElement(By.xpath("//textarea[@name='group_footer']"));
        fieldFooter.sendKeys(groupData.getFooter());
    }

    private void submitGroupCreation() {
        WebElement buttonEnterInfo = driver.findElement(By.xpath("//input[@name='submit']"));
        buttonEnterInfo.click();
    }

    private void returnToGroupPage(String nameGroup) {
        WebElement linkReturnGroupPage = driver.findElement(By.xpath("//div[@class='msgbox']//a"));
        linkReturnGroupPage.click();
        ArrayList<WebElement> groups = (ArrayList<WebElement>) driver.findElements(By.xpath("//div[@id='content']//span"));

        boolean findNeedGroup = false;
        for (WebElement group : groups) {
            String currName = group.getText();
            if (nameGroup.equals(currName)) {
                findNeedGroup = true;
                break;
            }
        }
        Assert.assertTrue(findNeedGroup);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        driver.quit();
    }
}