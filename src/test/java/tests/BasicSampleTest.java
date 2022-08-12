package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import base.Driver;
import pages.BasicSamplePage;

import java.io.IOException;

public class BasicSampleTest extends Driver {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validatePageTitle()
    {
        BasicSamplePage hp = new BasicSamplePage(driver);
        String title = hp.getTitle();
        Assert.assertEquals(title, "Buggy Rating");
    }

    @AfterTest
    public void shutdown()
    {
        driver.close();
    }
}
