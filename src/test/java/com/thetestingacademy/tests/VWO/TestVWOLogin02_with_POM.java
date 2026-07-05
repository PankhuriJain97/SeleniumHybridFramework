package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.POM.VWO.DashBoardPage;
import com.thetestingacademy.pages.POM.VWO.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin02_with_POM {

    /* D - Driver manager
    L - Locators
    V - Verification
     */

    @Test
    @Description("Invalid Login")
    public void login_invalid()
    {
        //D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        //L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.Login_invalid("user1", "pwd123");

        //V
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();

        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");

        driver.quit();

    }

    @Test
    @Description("Valid Login")
    public void login_valid()
    {
        //D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        //L
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Login_valid("neyiyos395@aspensif.com","Automation@123");

        DashBoardPage dashboardPage = new DashBoardPage(driver);
        String name = dashboardPage.loggedInUserName();

        assertThat(name).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(name,"Automation Testing");


        driver.quit();

    }
}
