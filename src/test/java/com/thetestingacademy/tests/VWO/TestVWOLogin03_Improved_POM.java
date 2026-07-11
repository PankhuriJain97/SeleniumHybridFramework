package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.pages.POM.VWO.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TestVWOLogin03_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin03_Improved_POM.class);

    @Test
    @Description("Invalid Login")
    public void invalid_login() {
        //WebDriver driver = new ChromeDriver();

        //driver.get(PropertiesReader.readKey("url"));

        logger.info("Browser is started...");

        LoginPage loginPage = new LoginPage(getDriver());

        logger.info("verifying invalid credentials ....");
        String error_msg = loginPage.Login_invalid(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        logger.info("Assertions...");
        logger.info(error_msg);
        assertThat(error_msg).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
}
