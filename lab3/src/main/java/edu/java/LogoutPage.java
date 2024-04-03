package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    private final WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div/div/div/main/div/div[2]/button")
    public WebElement logout;

    public LogoutPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void logoutBtnClick() {
        logout.click();
    }
}
