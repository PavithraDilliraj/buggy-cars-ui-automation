package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Register button locator
     */
    private final By _register_button = By.linkText("Register");

    /**
     * Register form locators
     */
    private final By _username = By.id("username");
    private final By _first_name = By.id("firstName");
    private final By _last_name = By.id("lastName");
    private final By _password = By.id("password");
    private final By _confirm_password = By.id("confirmPassword");

    /**
     * Confirm & Cancel button locators
     */
    private final By _confirm_button = By.xpath("//button[text()='Register']");
    private final By _cancel_button = By.linkText("//*[text()='Cancel']");

    /**
     * Success message
     */
    private final By _registration_success_message = By.cssSelector("[class*=alert-success]");


    public RegisterPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Interaction methods
    public void clickRegister(){
        driver.findElement(_register_button).click();
    }

    public void enterUsername(String username){
        driver.findElement(_username).sendKeys(username);
    }

    public void enterFirstName(String firstname){
        driver.findElement(_first_name).sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        driver.findElement(_last_name).sendKeys(lastname);
    }

    public void enterPassword(String password){
        driver.findElement(_password).sendKeys(password);
    }

    public void enterConfirmPassword(String confirm_password){
        driver.findElement(_confirm_password).sendKeys(confirm_password);
    }

    public void clickConfirm(){

        wait.until(ExpectedConditions.elementToBeClickable(_confirm_button)).click();
        /* TODO: Unable to perform click action using selenium method hence javascript executor is used */
        // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(_confirm_button));
        // JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].click();", element);
    }

    public void clickCancel(){
        driver.findElement(_cancel_button).click();
    }

    // API Or Workflow
    public void registerNewUser(JSONObject obj){
        clickRegister();
        enterUsername(obj.get("username").toString());
        enterFirstName(obj.get("firstname").toString());
        enterLastName(obj.get("lastname").toString());
        enterPassword(obj.get("password").toString());
        enterConfirmPassword(obj.get("confirm_password").toString());
        clickConfirm();
    }

    // Verification
    public String getRegistrationSuccessMessage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(_registration_success_message)).getText().trim();
    }
}
