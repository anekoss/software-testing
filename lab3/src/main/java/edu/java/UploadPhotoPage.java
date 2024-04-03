package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadPhotoPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/div/div[2]/label")
    public WebElement addPhoto;

    public UploadPhotoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void addPhotoBtnClick() {
        addPhoto.click();
    }

    public void uploadPhoto(String path) {
        addPhoto.sendKeys(String.valueOf(path));
    }
}
