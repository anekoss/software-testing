package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonHeightPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[1]/div/button")
    public WebElement height170;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[2]/div/button")

    public WebElement height190;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[3]/div/button")
    public WebElement heightHigh;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[4]/div/button")
    public WebElement heightAny;


    public PersonHeightPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void height170BtnClick() {
        height170.click();
    }

    public void height190BtnClick() {
        height190.click();
    }

    public void heightHighBtnClick() {
        heightHigh.click();
    }

    public void heightAnyBtnClick() {
        heightAny.click();
    }


    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
