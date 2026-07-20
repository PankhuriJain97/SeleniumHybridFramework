package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PF.LoginPage_PF;
import com.thetestingacademy.utils.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin04_PF extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin04_PF.class);

    @Test
    public void invalid_login()
    {
        logger.info("PF test cases");

        LoginPage_PF loginPage_pf = new LoginPage_PF(DriverManager.getDriver());

        String error_message = loginPage_pf.Login_invalid();

        assertThat(error_message).isNotBlank().isNotEmpty().isNotNull();
        Assert.assertEquals(error_message, PropertiesReader.readKey("error_message"));
    }
}
