package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginVariantsPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[1]")
    public WebElement email;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[2]")
    public WebElement vk;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[3]")
    public WebElement google;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[4]")
    public WebElement odnoklassniki;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[5]")
    public WebElement yandex;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[6]")
    public WebElement mail;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[7]")
    public WebElement yahoo;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[4]/div/div/div/div/a[8]")
    public WebElement viber;


    public LoginVariantsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void vkBtnClick() {
        vk.click();
    }

    public void googleBtnClick() {
        google.click();
    }

    public void odnoklassnikiBtnClick() {
        odnoklassniki.click();
    }

    public void yandexBtnClick() {
        yandex.click();
    }

    public void mailBtnClick() {
        mail.click();
    }

    public void yahooBtnClick() {
        yahoo.click();
    }

    public void viberBtnClick() {
        viber.click();
    }

    public void emailBtnClick() {
        email.click();
    }


    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
