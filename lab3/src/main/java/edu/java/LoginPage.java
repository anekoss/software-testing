package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/form/div[1]/div/input")
    public WebElement login;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/form/div[2]/div/div/input")
    public WebElement password;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/form/div[4]/input")
    public WebElement signIn;

    public WebElement forgetPassword;


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String login) {
        this.login.sendKeys(String.valueOf(login));
    }

    public void enterPassword(String password) {
        this.password.sendKeys(String.valueOf(password));
    }

    public void signInBtnClick() {
        signIn.click();
    }

    public void forgetPasswordBtnClick() {
        forgetPassword.click();
    }

    public WebElement getLoginError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div/div/div/main/form/div[1]/div/div/div"));
    }

    public WebElement getPasswordError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div/div/div/main/form/div[2]/div/div/div/div"));
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
