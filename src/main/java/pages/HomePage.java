package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Home Logo
     */
    private final By _home_logo = By.linkText("Buggy Rating");

    /**
     * Login fields locators
     */
    private final By _username = By.name("login");
    private final By _password = By.name("password");

    /**
     * Login button locators
     */
    private final By _login_button = By.xpath("//button[text()='Login']");

    /**
     * Navigation menus locators
     */
    private final By _welcome_label = By.xpath("//*[contains(text(), 'Hi')]");
    private final By _profile_link = By.linkText("Profile");
    private final By _logout_link = By.linkText("Logout");


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    // Interaction methods

    public void enterUsername(String username){
        driver.findElement(_username).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(_password).sendKeys(password);
    }

    public void clickLogin(){

        wait.until(ExpectedConditions.elementToBeClickable(_login_button)).click();

    }

    // Workflow
    public void login(JSONObject obj){
        enterUsername(obj.get("username").toString());
        enterPassword(obj.get("password").toString());
        clickLogin();
    }

    public Boolean isWelcomePresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_welcome_label)).isDisplayed();
    }

    public Boolean isProfileLinkPresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_profile_link)).isDisplayed();
    }

    public Boolean isLogoutLinkPresent(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(_logout_link)).isDisplayed();
    }
}
