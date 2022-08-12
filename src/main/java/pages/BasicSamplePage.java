package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicSamplePage {

    public WebDriver driver;

    private final String _title = ".navbar-brand";

    public BasicSamplePage(WebDriver driver)
    {
        this.driver=driver;
    }

    // Interaction methods
    public WebElement title(){
        return driver.findElement(By.cssSelector(_title));
    }

    // API Or Workflow
    public String getTitle(){
        return driver.findElement(By.cssSelector(_title)).getText();
    }
}
