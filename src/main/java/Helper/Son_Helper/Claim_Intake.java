package Helper.Son_Helper;

import BaseClass.TestBase;
import Helper.Verification_Helper.AssertionHelper;
import Helper.Verification_Helper.WaitHelper;
import Utility.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Claim_Intake extends TestBase {
    WaitHelper waitHelper;
    DropDown dropDown;
    public Claim_Intake(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
        dropDown=new DropDown(driver);
    }

    @FindBy(xpath = "(//span[contains(text(),'[None Selected]')])[1]")
    WebElement Cause1;
    @FindBy(xpath = "//span[contains(text(),' Accident ')]")
    WebElement Cause2;

    @FindBy(xpath = "//span[contains(text(),'[None Selected]')]")
    WebElement Category;

    @FindBy(xpath = "//span[contains(text(),' Annuity ')]")
    WebElement Category1;

    @FindBy(xpath = "//span[contains(text(),' Start Claim')]")
    public WebElement Start_Claim_Button;

    @FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[1]")
    public WebElement PlainTag;

    @FindBy(xpath = "(//input[starts-with(@id,'mat-input')])[2]")
    public WebElement PlanTagUrl;
    public void WaitForStartClaim(){
        waitHelper.WaitForTheElement(Start_Claim_Button);
        AssertionHelper.Verify_the_an_Element(Start_Claim_Button);
    }

    public void EnterDate_of_Death(){
        driver.findElement(By.xpath("//input[@id='v_datDeath_initial']")).sendKeys("06/19/2023");
    }

    public void EnterCauseOfDeath(int index,String value){
        dropDown.Handling_Drop_Down(Cause1,Cause2,Cause2);
    }

    public void EnterPlainCategory(int index, String value){
        dropDown.Handling_Drop_Down(Category,Category1,Category1);
    }

    public void EnterPlanCTag(String plantag,String planTagurl){
        PlainTag.sendKeys(plantag);
        PlanTagUrl.sendKeys(planTagurl);
        Start_Claim_Button.click();
    }
}
