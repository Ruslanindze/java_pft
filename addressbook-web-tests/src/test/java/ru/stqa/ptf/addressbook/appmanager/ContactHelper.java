package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver driver) {
        super(driver);
    }

    public void fillGroupForm(ContactData contactData) {
        type(By.xpath("//input[@name='firstname']"), contactData.getNameFirst());
        type(By.xpath("//input[@name='middlename']"), contactData.getNameMiddle());
        type(By.xpath("//input[@name='lastname']"), contactData.getNameLast());
        type(By.xpath("//input[@name='nickname']"), contactData.getNameNick());

        // Здесь будет pathToPhoto
        type(By.xpath("//input[@name='title']"), contactData.getTitle());
        type(By.xpath("//input[@name='company']"), contactData.getCompany());
        type(By.xpath("//textarea[@name='address']"), contactData.getAddress());

        type(By.xpath("//input[@name='home']"), contactData.getPhoneHome());
        type(By.xpath("//input[@name='mobile']"), contactData.getPhoneMobile());
        type(By.xpath("//input[@name='work']"), contactData.getPhoneWork());
        type(By.xpath("//input[@name='fax']"), contactData.getFax());

        type(By.xpath("//input[@name='email']"), contactData.getEmailFirst());
        type(By.xpath("//input[@name='email2']"), contactData.getEmailSecond());
        type(By.xpath("//input[@name='email3']"), contactData.getEmailThird());
        type(By.xpath("//input[@name='homepage']"), contactData.getHomePage());

        // Область заполнения Birthday (число, месяц, год)
        String[] listAboutBirthday = contactData.getBirthDay();
        select(By.xpath("//select[@name='bday']"), listAboutBirthday[0]);
        select(By.xpath("//select[@name='bmonth']"), listAboutBirthday[1]);
        type(By.xpath("//input[@name='byear']"), listAboutBirthday[2]);

        // Область заполнения Anniversary (число, месяц, год)
        String[] listAboutAnniversary = contactData.getAnniversary();
        select(By.xpath("//select[@name='aday']"), listAboutAnniversary[0]);
        select(By.xpath("//select[@name='amonth']"), listAboutAnniversary[1]);
        type(By.xpath("//input[@name='ayear']"), listAboutAnniversary[2]);

        // Область заполнения Group
        select(By.xpath("//select[@name='new_group']"), contactData.getGroup());

        type(By.xpath("//textarea[@name='address2']"), contactData.getSecondaryAddress());
        type(By.xpath("//input[@name='phone2']"), contactData.getSecondaryHome());
        type(By.xpath("//textarea[@name='notes']"), contactData.getSecondaryNotes());
    }
}
