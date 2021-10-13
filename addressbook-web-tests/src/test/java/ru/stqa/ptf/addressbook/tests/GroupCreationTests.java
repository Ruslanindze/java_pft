package ru.stqa.ptf.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("Clan Marpha", "Koza Dereza", "Myauuu!!!"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }
}