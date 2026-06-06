package com.thetestingacademy.pages.POM.VWO;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private By Dashboardbutton = By.xpath("//a[@aria-label='View dashboard']");
    private By userNameonDashboard = By.xpath("//span[@data-qa='lufexuloga']");

    public String UserLoggedIn()
    {
        WaitHelpers.waitJVM(10000);
        WaitHelpers.checkVisibility(driver,Dashboardbutton);
        driver.findElement(Dashboardbutton).click();
        WaitHelpers.checkVisibility(driver,userNameonDashboard);
        return driver.findElement(userNameonDashboard).getText();
    }

}
