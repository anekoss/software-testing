package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterNamePage {

    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[1]/div/input")
    public WebElement name;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[3]/div/input")
    public WebElement next;


    public EnterNamePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void enterName(String name) {
        this.name.sendKeys(String.valueOf(name));
    }

    public void nextBtnClick() {
        next.click();
    }


    public WebElement getError() {
        return webDriver.findElement(By.xpath("//*[@id=\"VideoBackgroundModalLayout\"]/div[2]/main/div/div/main/form/div[1]/div/div/div"));
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
