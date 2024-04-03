package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CityListPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[1]")
    public WebElement moscow;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[2]")
    public WebElement saintPetersburg;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[3]")
    public WebElement novosibirsk;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[4]")
    public WebElement ekaterinburg;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[5]")
    public WebElement nizhniyNovgorod;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[6]")
    public WebElement kazan;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[7]")
    public WebElement omsk;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[8]")
    public WebElement samara;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[9]")
    public WebElement chelyabinsk;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[10]")
    public WebElement rostovOnDon;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[11]")
    public WebElement ufa;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[12]")
    public WebElement perm;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[13]")
    public WebElement volgograd;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[14]")
    public WebElement krasnoyarsk;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div[2]/div/div/div/div/a[15]")
    public WebElement voronezh;

    public CityListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void moscowBtnClick() {
        moscow.click();
    }

    public void saintPetersburgBtnClick() {
        saintPetersburg.click();
    }

    public void novosibirskBtnClick() {
        novosibirsk.click();
    }

    public void ekaterinburgBtnClick() {
        ekaterinburg.click();
    }

    public void nizhniyNovgorodBtnClick() {
        nizhniyNovgorod.click();
    }

    public void kazanBtnClick() {
        kazan.click();
    }

    public void omskBtnClick() {
        omsk.click();
    }

    public void samaraBtnClick() {
        samara.click();
    }

    public void chelyabinskBtnClick() {
        chelyabinsk.click();
    }

    public void rostovOnDonBtnClick() {
        rostovOnDon.click();
    }

    public void ufaBtnClick() {
        ufa.click();
    }

    public void permBtnClick() {
        perm.click();
    }

    public void volgogradBtnClick() {
        volgograd.click();
    }

    public void krasnoyarskBtnClick() {
        krasnoyarsk.click();
    }

    public void voronezhBtnClick() {
        voronezh.click();
    }


    public void waitForUrl(String url) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
