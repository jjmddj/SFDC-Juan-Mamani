package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;

/**
 * Created by Juan Mamani on 10/08/2015.
 */
public class AddAccount {

    @Test()
    public void testAddProject() {
        String account = "Juan5";
        String opportunitie = "opport5";
        String closeDate = "8/13/2015";
        String stage = "Qualification";

        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.clickLoginBtn()
                .setEmailTxt("jjmddj@gmail.com")
                .setPasswordTxt("Control123");
        MainApp mainApp = loginPage.clickLoginBtn();

        TopMenu topMenu = mainApp.goToLeftMenu();


        // Create a new Accounts
       AddItemForm addItemForm = topMenu.clickaccountsLnk()
                .clickNewBtn()
                .setAccountNameTxt(account)
               .clickSaveBtn();
        //Verify if accounts was created
        Assert.assertEquals(addItemForm.getAccount(account), account);



        // Create a new Opportunities
        AddItemForm addOpportunitiesForm = topMenu.clickOpportunitiesLnkLnk()
                .clickNewBtn()
                .setOpportunityName(opportunitie)
                .setAccountNameInOpportunityTxt(account)
                .setCloseDate(closeDate)
                .selectStage(stage)
                .clickSaveBtn();
        //Verify if Opportunities was created
        Assert.assertEquals(addOpportunitiesForm.getAccount(opportunitie), opportunitie);
        //Verify if account was added in Opportunities
        Assert.assertEquals(addOpportunitiesForm.getAccountNamefromOpportunityDetail(account), account);
        //Verify if stage was added in Opportunities details
        Assert.assertEquals(addOpportunitiesForm.getCloseDate(), closeDate);


        // Delete Account created
        AddItemForm deleteAccount = topMenu.clickaccountsLnk()
                .ClickMassDeleteAccountsBtn()
                .FindAccountName("ACCOUNT.NAME")
                .setSelectMatch("e")
                .setAccountDelete(account)
                .clickSearchBtn()
                .CheckaccountNameDelete()
                .ClickDeleteBtn();

        topMenu.clickaccountsLnk();
    }
}

