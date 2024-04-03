package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div/div[2]/div/section/nav/div[3]/div/a/svg")
    public WebElement settings;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div/div[2]/div/section/div[3]/div[1]/div/a/div[2]/svg/path")
    public WebElement editName;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[3]/div/div[2]/div/section/div[2]/div[1]/a/div")
    public WebElement addPhoto;

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void settingsBtnClick() {
        settings.click();
    }

    public void editNameBtnClick() {
        editName.click();
    }

    public void addPhotoBtnClick() {
        addPhoto.click();
    }
}
