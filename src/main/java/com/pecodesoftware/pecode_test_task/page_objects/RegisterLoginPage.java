package com.pecodesoftware.pecode_test_task.page_objects;

import com.pecodesoftware.pecode_test_task.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterLoginPage {

    final String url;
    private final WebDriver driver;
    @FindBy(xpath = "//input[@name='username' and @placeholder='Username']")
    private WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password' and @placeholder='Password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@class='btn btn-success' and @value='Login']")
    private WebElement loginButton;
    PropertiesReader propertiesReader;

    public RegisterLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        propertiesReader = new PropertiesReader();
        url = propertiesReader.getProperty("url");
    }

    public void enterUsernameInput(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUsernameInputPresent() {
        return driver.findElements(By.xpath("//input[@name='username' and @placeholder='Username']")).size() > 0;
    }

    public boolean isPasswordInputPresent() {
        return driver.findElements(By.xpath("//input[@name='password' and @placeholder='Password']")).size() > 0;
    }

    public boolean isLoginButtonPresent() {
        return driver.findElements(By.xpath("//input[@class='btn btn-success' and @value='Login']")).size() > 0;
    }

    public boolean isNoUsernameErrorAppear() {
        return driver.findElements(By.xpath("//span[contains(text(),'Please enter username.')]")).size() > 0;
    }

    public boolean isNoPasswordErrorAppear() {
        return driver.findElements(By.xpath("//span[contains(text(),'Please enter your password.')]")).size() > 0;
    }

    public boolean isNoAccountFoundErrorAppear() {
        return driver.findElements(By.xpath("//span[contains(text(),'No account found with that username.')]")).size() > 0;
    }

    public void open() {
        driver.get(url);
    }
}
