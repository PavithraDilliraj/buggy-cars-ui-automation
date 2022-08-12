package tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import base.Driver;
import pages.*;

import java.io.FileReader;
import java.io.IOException;

public class BuggyCarsTest extends Driver {

    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void navigate() {
        driver.get(prop.getProperty("url"));
    }

    @Test
    //Verify if Registration of a New User is successful
    public void TC1_validateUserRegistration() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/data.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        RegisterPage register = new RegisterPage(driver);
        register.registerNewUser((JSONObject) obj);
        String success_message = register.getRegistrationSuccessMessage();
        Assert.assertEquals(success_message, "Registration is successful");
    }

    @Test
    //Verify if user is able to Log in with newly created user credentials
    public void TC2_validateUserLogin() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+"/src/main/resources/data.json");
        //Read JSON file
        Object obj = jsonParser.parse(reader);
        HomePage home = new HomePage(driver);
        home.login((JSONObject) obj);
        Boolean welcome_label = home.isWelcomePresent();
        Assert.assertTrue(welcome_label);
        Boolean profile_link = home.isProfileLinkPresent();
        Assert.assertTrue(profile_link);
        Boolean logout_link = home.isLogoutLinkPresent();
        Assert.assertTrue(logout_link);
    }

    @Test
    //Verify is user is able to view Popular Make page
    public void TC3_validatePopularMake() {
        PopularMakePage popularMake = new PopularMakePage(driver);
        popularMake.popularMake();
        Boolean popularMakeTable = popularMake.isPopularMakePresent();
        Assert.assertTrue(popularMakeTable);
    }

    @Test
    //Verify is user is able to view Popular Model page
    public void TC4_validatePopularModel() {
        PopularModelPage popularModel = new PopularModelPage(driver);
        popularModel.popularModel();
        Boolean commentOption = popularModel.isVoteCommentPresent();
        Assert.assertTrue(commentOption);
    }

    @Test
    //Verify is user is able to view Overall Rating page
    public void TC5_validateOverallRating() {
        OverallRatingPage overallRating = new OverallRatingPage(driver);
        overallRating.overallRating();
        Boolean overallRatingTable = overallRating.isOverallRatingTablePresent();
        Assert.assertTrue(overallRatingTable);
    }


    @AfterTest
    public void shutdown()
    {
        driver.close();
    }
}
