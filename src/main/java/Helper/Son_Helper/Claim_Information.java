package Helper.Son_Helper;

import BaseClass.TestBase;
import Helper.Verification_Helper.AssertionHelper;
import Helper.Verification_Helper.WaitHelper;
import Utility.DropDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Claim_Information extends TestBase {

    WaitHelper waitHelper;
    DropDown dropDown;
    public Claim_Information(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
        dropDown=new DropDown(driver);
    }

    @FindBy(xpath = "(//div[contains(text(),'Claim Information')])[2]")
    public WebElement Wait_for_Claim_information;

    public void WaitForClaimInformation(){
        waitHelper.WaitForTheElement(Wait_for_Claim_information);
        AssertionHelper.Verify_the_an_Element(Wait_for_Claim_information);
    }

}
