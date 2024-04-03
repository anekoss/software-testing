package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinalStepPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[1]/div/input")
    public WebElement email;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[2]/div/button")
    public WebElement registration;


    public FinalStepPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void registrationBtnClick() {
        registration.click();
    }

    public void inputEmail(String email) {
        this.email.sendKeys(String.valueOf(email));
    }

    public WebElement getError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[1]/div/div/div"));
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
