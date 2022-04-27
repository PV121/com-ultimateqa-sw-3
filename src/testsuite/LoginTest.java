package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void openBrowserLogin() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));

        verifyText("Welcome Message: ","Welcome Back!",By.xpath("//h1[@class='page__heading']"));


    }
    @Test
    public void verifyTheErrorMessage(){
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));

        sendTextToElement(By.xpath("//input[@type='email']"),"vp@gmail.com");
        sendTextToElement(By.xpath("//input[@type='password']"),"1234586");
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText("Error Message: ","Invalid email or password.", By.xpath("//li[@class='form-error__list-item']"));
        
    }

    @After
    public void closeBrowserLogin() {
        closeBrowser();
    }
}
