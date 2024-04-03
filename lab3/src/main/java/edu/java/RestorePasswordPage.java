package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestorePasswordPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[1]/div/div/div/div/div[1]")

    public WebElement email;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[1]/div/div/div/div/div[2]")
    public WebElement number;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[1]/div/div/div/div/div[4]")
    public WebElement viber;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[2]/div/input")
    public WebElement emailField;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[2]/div/div[2]/input")
    public WebElement numberField;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[4]/div/input")
    public WebElement emailRestore;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[4]/div/input")
    public WebElement numberRestore;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[4]/div/input")
    public WebElement viberRestore;

    public RestorePasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void emailBtnClick() {
        email.click();
    }

    public void numberBtnClick() {
        number.click();
    }

    public void viberBtnClick() {
        viber.click();
    }

    public void emailRestoreBtnClick() {
        emailRestore.click();
    }

    public void numberRestoreBtnClick() {
        numberRestore.click();
    }

    public void viberRestoreBtnClick() {
        viberRestore.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(String.valueOf(email));
    }

    public void enterNumber(String number) {
        emailField.sendKeys(String.valueOf(number));
    }

    public WebElement getEmailError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[2]/div/div/div"));
    }

    public WebElement getNumberError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div/div/div/main/div/div[2]/form/div[2]/div[2]"));
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
