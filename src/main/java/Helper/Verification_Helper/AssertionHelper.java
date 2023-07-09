package Helper.Verification_Helper;

import BaseClass.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertionHelper extends TestBase {
    static WebDriver driver;
    static String image;


    public static synchronized boolean verifyElementPresent( WebElement element) {
        boolean isDispalyed = false;
        try {
            isDispalyed= element.isDisplayed();
            System.out.println(element.getText()+"is displayed");
        }
        catch(Exception ex) {
            System.out.println("Element is not Found:"+ex);
        }

        return isDispalyed;

    }

    public static synchronized boolean verifyElementNotPresent( WebElement element) {
        boolean isDispalyed = false;
        try {
            element.isDisplayed();
            System.out.println(element.getText()+"is Displayed");
        }
        catch(Exception ex) {
            System.out.println("Element is not Found:-"+ex);
            isDispalyed = true;
        }

        return isDispalyed;
    }

    public static synchronized boolean verifyTextEquals( WebElement element,String expectedText) {
        boolean flag = false;
        try {
            String actualText=element.getText();
            if(actualText.equals(expectedText)) {
                System.out.println("Actual Text is :"+actualText+ "Expected Text is : "+expectedText);
                return flag=true;
            }
            else {
                System.out.println("Actual Text is :"+actualText+ "Expected Text is : "+expectedText);
                return flag;
            }
        }
        catch(Exception ex) {
            System.out.println("Actual Text is :"+element.getText()+" Expected Text is : "+expectedText);
            System.out.println("Text is not Matching"+ex);
            return false;
        }
    }


    public static synchronized boolean Verify_the_an_Element(WebElement element) {
        boolean isDispalyed = false;
        try {
            isDispalyed= element.isDisplayed();
            System.out.println(element.getText()+" is displayed");
        }
        catch(Exception ex) {
            System.out.println("Element is not Found:"+ex);
            TestBase.captureScreenshot(image);
        }

        return isDispalyed;

    }
}
