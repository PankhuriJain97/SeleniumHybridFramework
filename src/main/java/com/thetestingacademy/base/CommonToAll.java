package com.thetestingacademy.base;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAll {

    public void openVWOUrl()
    {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    public void openOrangeHRMUrl()
    {
        getDriver().get(PropertiesReader.readKey("ohr_url"));
    }

    public void openKatalonUrl()
    {
        getDriver().get(PropertiesReader.readKey("katalon_url"));
    }

    public void clickElement(By by)
    {
        getDriver().findElement(by).click();

    }

    public void enterValue(By by, String value)
    {
        getDriver().findElement(by).sendKeys(value);
    }

    public String getText(By by)
    {
        return getDriver().findElement(by).getText();
    }

    public void enterValue(WebElement element, String value)
    {
        element.sendKeys(value);
    }

    public void clickElement(WebElement element)
    {
        element.click();

    }
    public String getText(WebElement element)
    {
        return element.getText();
    }
}
