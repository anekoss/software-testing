package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectDatingPurposePage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[2]/div/button")
    public WebElement seriousRelationship;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[3]/div/button")
    public WebElement friendlyRelationship;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[4]/div/button")
    public WebElement flirt;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[5]/div/button")
    public WebElement simply;

    public SelectDatingPurposePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void seriousRelationshipBtnClink() {
        seriousRelationship.click();
    }

    public void friendlyRelationshipBtnClink() {
        friendlyRelationship.click();
    }

    public void flirtBtnClink() {
        flirt.click();
    }

    public void simplyBtnClink() {
        simply.click();
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
