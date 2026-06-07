package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.POM.VWO.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin03_Improved_POM {

    @Test
    @Description("Invalid Login")
    public void invalid_login() {
        WebDriver driver = new ChromeDriver();
        driver.get(PropertiesReader.readKey("url"));

        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.Login_invalid(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
}
