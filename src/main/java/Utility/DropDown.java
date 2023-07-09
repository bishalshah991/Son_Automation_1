package Utility;

import BaseClass.TestBase;
import Helper.Verification_Helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DropDown extends TestBase {
    WaitHelper waitHelper;

    public DropDown(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        waitHelper=new WaitHelper(driver,20);
    }

    @FindBy(xpath = "//div[contains(@class,'mat-select-arrow')]")
    public WebElement classicDropdownXpath;


    public void Handling_Drop_Down(WebElement element,WebElement element1,WebElement element3) {
        element.click();
        waitHelper.WaitForTheElement(element1);
        element3.click();
    }

}
