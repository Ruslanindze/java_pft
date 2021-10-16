package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.GroupData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddContact();
        app.getContactHelper().fillGroupForm(ContactData.getContactData("src/test/resources/newContact.json"));


//        app.getGroupHelper().submitGroupCreation();
//        app.getGroupHelper().returnToGroupPage();
    }
}