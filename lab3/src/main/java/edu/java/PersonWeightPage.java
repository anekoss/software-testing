package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonWeightPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[1]/div/button")
    public WebElement weight60;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[2]/div/button")
    public WebElement weight80;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[3]/div/button")
    public WebElement weight100;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[4]/div/button")
    public WebElement weightHigh;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[5]/div/button")
    public WebElement weightAny;

    public PersonWeightPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void weight60BtnClick(){
        weight60.click();
    }

    public void weight80BtnClick(){
        weight80.click();
    }

    public void weight100BtnClick(){
        weight100.click();
    }
    public void weightHighBtnClick(){
        weightHigh.click();
    }

    public void weightAnyBtnClick(){
        weightAny.click();
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
