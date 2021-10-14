package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ConfProperties;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    FirefoxDriver driver;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.gecko.driver", ConfProperties.getProperty("firefoxDriver"));
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginPage"));
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login();
    }

    public void stop() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(3000);
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
