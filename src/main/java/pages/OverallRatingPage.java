package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OverallRatingPage {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Popular Make Logo
     */
    private final By _overall_rating_logo = By.xpath("//img[contains(@src, 'overall')]");

    /**
     * Popular Make table locators
     */
    private final By _overall_rating_table = By.xpath("//table[contains(@class, 'cars table')]");


    public OverallRatingPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Interaction methods

    public void clickOverallRatingLogo(){

        wait.until(ExpectedConditions.elementToBeClickable(_overall_rating_logo)).click();

    }

    // API Or Workflow
    public void overallRating(){
        clickOverallRatingLogo();
    }

    public Boolean isOverallRatingTablePresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_overall_rating_table)).isDisplayed();
    }
}
