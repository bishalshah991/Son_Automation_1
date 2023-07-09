package TestCase;

import BaseClass.TestBase;
import Helper.Son_Helper.Claim_Intake;
import Helper.Son_Helper.PolicySearch;
import SON_Pages.LoginPage;
import Utility.Read_Json_Data;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class End_End_Step extends TestBase {

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+"Data.json";
    @Test
    public void Son_Flow_End_to_End() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        Read_Json_Data readJsonData=new Read_Json_Data();
        PolicySearch policySearch=new PolicySearch(driver);
        Claim_Intake claimIntake=new Claim_Intake(driver);
        String Email=readJsonData.ReadJSONData("Username");
        String Password=readJsonData.ReadJSONData("Password");
        loginPage.Wait_For_Login_Text();
        loginPage.Login_to_Application(Email,Password);
        policySearch.PolicySearchTab();
        policySearch.EnterThePolicySearchBox(readJsonData.ReadJSONData("Policy_number"));
        policySearch.WaitForActive();
        policySearch.ClickBeginClaims();
        claimIntake.WaitForStartClaim();
        claimIntake.EnterDate_of_Death();
        String v1="Natural";
        claimIntake.EnterCauseOfDeath(2,v1);
        String v2="Cancer";
        claimIntake.EnterPlainCategory(2,v2);
        String v3="test";
        String v4="test1";
        claimIntake.EnterPlanCTag(v3,v4);

    }
}
