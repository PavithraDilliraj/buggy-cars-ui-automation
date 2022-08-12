package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularModelPage {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Popular Model Logo
     */
    private final By _popular_model_logo = By.xpath("//img[@title='Guilia Quadrifoglio']");

    /**
     * Popular Model table locators
     */
    private final By _popular_model_comment = By.id("comment");


    public PopularModelPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Interaction methods

    public void clickPopularModelLogo(){

        wait.until(ExpectedConditions.elementToBeClickable(_popular_model_logo)).click();

    }

    // API Or Workflow
    public void popularModel(){
        clickPopularModelLogo();
    }

    public Boolean isVoteCommentPresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_popular_model_comment)).isDisplayed();
    }

}
