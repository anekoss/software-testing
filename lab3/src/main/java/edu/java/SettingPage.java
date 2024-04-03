package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/main/a/div[1]/div[2]")
    public WebElement logout;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/main/label/div[1]/div[2]")
    public WebElement deleteProfile;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/main/a/div[1]/div/span")
    public WebElement confirmDeleteProfile;

    public SettingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void logoutBtnClick() {
        logout.click();
    }

    public void deleteProfileBtnClick() {
        deleteProfile.click();
    }

    public void confirmDeleteProfile() {
        confirmDeleteProfile.click();
    }
}
