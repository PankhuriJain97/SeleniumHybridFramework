package com.thetestingacademy.pages.PF;

import com.thetestingacademy.base.CommonToAll;
import com.thetestingacademy.utils.PropertiesReader;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage_PF extends CommonToAll {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Page locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private  WebElement signButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public String Login_invalid()
    {
        try {

            openVWOUrl();
            enterValue(username, PropertiesReader.readKey("invalid_username"));
            enterValue(password, PropertiesReader.readKey("invalid_password"));


            clickElement(signButton);
            WaitHelpers.checkVisibility(getDriver(), error_message);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return getText(error_message);
    }



}
