package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[1]/a")
    public WebElement countries;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[3]/a")
    public WebElement confidentiality;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[1]/header/div/a")
    public WebElement signIn;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[1]/div/div[1]")
    public WebElement genderMan;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/main/div/div/main/div[1]/div/div[2]")
    public WebElement genderWoman;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[1]/a")
    public WebElement technologies;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[2]/a")
    public WebElement cities;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div[2]/div/div[3]/div[4]/a")
    public WebElement journal;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void countriesBtnClick() {
        countries.click();
    }

    public void confidentialityBtnClick() {
        confidentiality.click();
    }

    public void signInBtnClick() {
        signIn.click();
    }

    public void genderManBtnClick() {
        genderMan.click();
    }

    public void genderWomanBtnClick() {
        genderWoman.click();
    }

    public void citiesBtnClick() {
        cities.click();
    }

    public void journalBtnClick() {
        journal.click();
    }
    public void technologiesBtnClick(){
        technologies.click();
    }

    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

}
