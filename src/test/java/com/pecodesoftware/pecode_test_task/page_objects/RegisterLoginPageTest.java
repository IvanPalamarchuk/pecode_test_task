package com.pecodesoftware.pecode_test_task.page_objects;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import test_utils.SearchTestUtils;

import static test_utils.SearchTestUtils.saveScreenshot;

class RegisterLoginPageTest {

    private WebDriver driver;
    private RegisterLoginPage registerLoginPage;

    @BeforeEach
    void setUp() {
        SearchTestUtils searchTestUtils = new SearchTestUtils();
        driver = searchTestUtils.getConfiguredChromeDriver();
        registerLoginPage = new RegisterLoginPage(this.driver);
    }

    @AfterEach
    void tearDown() {
        saveScreenshot(driver);
        driver.quit();
    }

    @Test
    @Description("Task #4")
    void loginAndVerifyElementsPresent() {
        registerLoginPage.open();
        registerLoginPage.enterUsernameInput("user_name");
        registerLoginPage.enterPasswordInput("password");
        registerLoginPage.clickLoginButton();
        Assertions.assertTrue(registerLoginPage.isUsernameInputPresent());
        Assertions.assertTrue(registerLoginPage.isPasswordInputPresent());
        Assertions.assertTrue(registerLoginPage.isLoginButtonPresent());
    }

    @Test
    @Description("Task #5")
    void verifyThatNoUsernameErrorAppear() {
        registerLoginPage.open();
        registerLoginPage.enterPasswordInput("password");
        registerLoginPage.clickLoginButton();
        Assertions.assertTrue(registerLoginPage.isNoUsernameErrorAppear());
    }

    @Test
    @Description("Task #5")
    void verifyThatNoPasswordErrorAppear() {
        registerLoginPage.open();
        registerLoginPage.enterUsernameInput("user_name");
        registerLoginPage.clickLoginButton();
        Assertions.assertTrue(registerLoginPage.isNoPasswordErrorAppear());
    }

    @Test
    @Description("Task #5")
    void verifyThatNoAccountFoundErrorAppear() {
        registerLoginPage.open();
        registerLoginPage.enterUsernameInput("user_name");
        registerLoginPage.enterPasswordInput("password");
        registerLoginPage.clickLoginButton();
        Assertions.assertTrue(registerLoginPage.isNoAccountFoundErrorAppear());
    }

    @Test
    @Description("Task #6")
    void verifyThatUserCanLogin() {
        registerLoginPage.open();
        registerLoginPage.enterUsernameInput("user_name");
        registerLoginPage.enterPasswordInput("password");
        registerLoginPage.clickLoginButton();
        Assertions.assertNotEquals(driver.getCurrentUrl(), registerLoginPage.url);
    }
}