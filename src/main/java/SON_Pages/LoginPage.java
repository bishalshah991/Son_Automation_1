package SON_Pages;

import BaseClass.TestBase;
import Helper.Verification_Helper.AssertionHelper;
import Helper.Verification_Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    WaitHelper waitHelper;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
    }

    @FindBy(xpath = "//h1[contains(text(),'LOGIN TO YOUR ACCOUNT')]")
    public WebElement TextLoginPage;

    @FindBy(xpath = "//form[@name='loginForm']/child::div/span")
    public WebElement Version;
    @FindBy(xpath = "//input[@placeholder='Email']")
    public WebElement UsernameXpath;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement PasswordXpath;

    @FindBy(xpath = "//span[normalize-space()='LOGIN']")
    public WebElement LoginButton;

    @FindBy(xpath = "//div[@class='advanced-pie chart']")
    WebElement PaymentOverview;


    /*
        Logout From Application
     */

    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_down')]")
    public WebElement LogoutArrow;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement Sign_out_text;

    public void Wait_For_Login_Text(){
        waitHelper.WaitForTheElement(TextLoginPage);
        AssertionHelper.Verify_the_an_Element(TextLoginPage);
    }

    public void Login_to_Application(String username,String password){
        UsernameXpath.sendKeys(username);
        PasswordXpath.sendKeys(password);
        LoginButton.click();
        waitHelper.WaitForTheElement(PaymentOverview);
    }

    public void Logout_from_Application(){
        LogoutArrow.click();
        waitHelper.WaitForTheElement(Sign_out_text);
        Sign_out_text.click();
    }






}
