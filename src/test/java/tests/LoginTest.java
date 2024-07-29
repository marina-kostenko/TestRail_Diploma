package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.PropertyReader;

import java.util.List;

public class LoginTest extends BaseTest {

    @DataProvider(name = "test data for negative login with one empty field")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{{"tmsqa26lika@mailinator.com", "", "Password is required."}, {"", "As50555327!", "Email/Login is required."},};
    }

    @DataProvider(name = "test data for negative login with wrong data")
    public Object[][] negativeWrongLoginTestData() {
        return new Object[][]{{"tmsqalika@mailinator.com", "As50555327!", "Email/Login or Password is incorrect. Please try again."}, {"tmsqa26lika@mailinator.com", "As50555327", "Email/Login or Password is incorrect. Please try again."},};
    }

    @Test(groups = "smoke", description = "Positive login test")
    public void positiveLoginTest() {
        loginPage.isPageOpened();
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
        Assert.assertTrue(dashboardPage.isUserNameDisplayed());
    }

    @Test(groups = "regression", description = "Negative login test with one empty field", dataProvider = "test data for negative login with one empty field")
    public void negativeLoginTestWithOneEmptyField(String email, String password, String expectedErrorMessage) {
        loginPage.isPageOpened();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isErrorMessageNearTheFieldDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageNearTheFieldText(), expectedErrorMessage);
    }

    @Test(groups = "regression", description = "Negative login test with empty fields")
    public void negativeLoginTestWithEmptyFields() {
        List<String> errorTexts = List.of("Email/Login is required.", "Password is required.");
        loginPage.isPageOpened();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrors(), errorTexts);
    }

    @Test(groups = "regression", description = "Negative login test with wrong data", dataProvider = "test data for negative login with wrong data")
    public void negativeLoginTestWithWrongData(String email, String password, String expectedErrorMessage) {
        loginPage.isPageOpened();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

}
