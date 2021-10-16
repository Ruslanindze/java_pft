package ru.stqa.ptf.addressbook.model;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ContactData {

    private String nameFirst;
    private String nameMiddle;
    private String nameLast;
    private String nameNick;

    private String pathToPhoto;
    private String title;
    private String company;
    private String address;

    private String phoneHome;
    private String phoneMobile;
    private String phoneWork;
    private String fax;

    private String emailFirst;
    private String emailSecond;
    private String emailThird;
    private String homePage;
    private String birthDay;
    private String anniversary;
    private String group;

    private String secondaryAddress;
    private String secondaryHome;
    private String secondaryNotes;


    public String getNameFirst() {
        return nameFirst;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }

    public String getNameLast() {
        return nameLast;
    }

    public String getNameNick() {
        return nameNick;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public String getFax() {
        return fax;
    }

    public String getEmailFirst() {
        return emailFirst;
    }

    public String getEmailSecond() {
        return emailSecond;
    }

    public String getEmailThird() {
        return emailThird;
    }

    public String getHomePage() {
        return homePage;
    }

    public String[] getBirthDay() {
        String[] returnBirthday = birthDay.split(" ");
        return returnBirthday;
    }

    public String[] getAnniversary() {
        String[] returnAnniversary = anniversary.split(" ");
        return returnAnniversary;
    }

    public String getGroup() {
        return group;
    }

    public String getSecondaryAddress() {
        return secondaryAddress;
    }

    public String getSecondaryHome() {
        return secondaryHome;
    }

    public String getSecondaryNotes() {
        return secondaryNotes;
    }


    public static ContactData getContactData(String pathToJson) {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(pathToJson));
            ContactData contactData = gson.fromJson(br, ContactData.class);
            return contactData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String [] args) {
        ContactData.getContactData("F:\\FreeRus\\Training\\Dev\\Java\\JavaForTesters\\java_pft\\addressbook-web-tests\\src\\test\\resources\\newContact.json").
                getBirthDay();
    }
}