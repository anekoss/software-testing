package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnterBirthdayPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[2]/div/div[1]/label/select")
    public WebElement day;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[2]/div/div[2]/label/select")
    public WebElement month;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[2]/div/div[3]/label/select")
    public WebElement year;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/form/div[4]/div/input")
    public WebElement next;

    public EnterBirthdayPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void chooseDay(int value) {
        day.sendKeys(String.valueOf(value));
    }

    public void chooseMonth(String value) {
        month.sendKeys(String.valueOf(value));
    }

    public void chooseYear(int value) {
        year.sendKeys(String.valueOf(value));
    }

    public WebElement getError() {
        return webDriver.findElement(By.xpath("/section/div/section/div[2]/div"));
    }

    public void nextBtnClick() {
        next.click();
    }


    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
