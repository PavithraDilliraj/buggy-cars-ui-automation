package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularMakePage {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Popular Make Logo
     */
    private final By _popular_make_logo = By.xpath("//img[@title='Alfa Romeo']");

    /**
     * Popular Make table locators
     */
    private final By _popular_make_table = By.xpath("//table[contains(@class, 'cars table')]");


    public PopularMakePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Interaction method

    public void clickPopularMakeLogo(){

        wait.until(ExpectedConditions.elementToBeClickable(_popular_make_logo)).click();

    }

    // API Or Workflow
    public void popularMake(){
        clickPopularMakeLogo();
    }

    // Verification
    public Boolean isPopularMakePresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_popular_make_table)).isDisplayed();
    }
}
