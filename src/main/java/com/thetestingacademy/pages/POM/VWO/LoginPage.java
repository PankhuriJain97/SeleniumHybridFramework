package com.thetestingacademy.pages.POM.VWO;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    /* PAGE CLASS*/

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");
    //private By freeTrial = By.xpath("//button[normalize-space()='Sign in using SSO']");
    //private By rememberMeButton = By.xpath("//button[normalize-space()='Sign in using SSO']");

    //Page Actions

    public String Login_invalid(String usr, String pwd)
    {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver, error_message);

        String error_msg = driver.findElement(error_message).getText();

        return error_msg;
    }

    public void Login_valid(String usr, String pwd)
    {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

    }

}
