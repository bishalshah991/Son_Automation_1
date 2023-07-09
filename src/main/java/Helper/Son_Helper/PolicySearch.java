package Helper.Son_Helper;

import BaseClass.TestBase;
import Helper.Verification_Helper.AssertionHelper;
import Helper.Verification_Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PolicySearch extends TestBase {
    WaitHelper waitHelper;

    public PolicySearch(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
    }

    @FindBy(xpath = "//span[contains(text(),'Policy Search')]")
    WebElement Policy_search_Tab;
    @FindBy(xpath = "//input[@placeholder='Type keywords and Press Enter....']")
    WebElement Type_Key_Enter;

    @FindBy(xpath = "//input[@id='searchInput']")
    WebElement Policy_search_Text_Box;

    @FindBy(xpath = "//div[contains(text(),'Active')]")
    public WebElement Active;

    @FindBy(xpath = "//div[contains(text(),'Settled')]")
    public WebElement Settled;

    @FindBy(xpath = "//mat-table[starts-with(@class,'mat-table cdk-table mat-sort ng-tns')]/mat-row/mat-cell[12]/div/button/span[1]/mat-icon")
    public WebElement Action_Three_Dots;

    @FindBy(xpath = "//span[contains(text(),'Begin Claim')]")
    public WebElement Begin_Claim;


    @FindBy(xpath = "//div[contains(text(),'Start Claim')]")
    WebElement StartClaim;

    public void PolicySearchTab(){
        Policy_search_Tab.click();
        waitHelper.WaitForTheElement(Type_Key_Enter);
        AssertionHelper.Verify_the_an_Element(Type_Key_Enter);
    }

    public void EnterThePolicySearchBox(String PolicyNumber) {
        Policy_search_Text_Box.sendKeys(PolicyNumber);
    }

    public void WaitForActive(){
        waitHelper.WaitForTheElement(Active);
        AssertionHelper.Verify_the_an_Element(Active);
    }

    public void ClickBeginClaims(){
        Action_Three_Dots.click();
        waitHelper.WaitForTheElement(Begin_Claim);
        AssertionHelper.Verify_the_an_Element(Begin_Claim);
        Begin_Claim.click();
        waitHelper.WaitForTheElement(StartClaim);
        AssertionHelper.Verify_the_an_Element(StartClaim);
        StartClaim.click();
    }

}
