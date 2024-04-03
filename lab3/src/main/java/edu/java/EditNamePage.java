package edu.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditNamePage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/main/form/div[1]/div/div/input")
    public WebElement name;
    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/main/form/div[2]/div/input")
    public WebElement send;

    public EditNamePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void nameBtnClick() {
        name.click();
    }

    public void sendBtnClick() {
        send.click();
    }

    public WebElement getError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/main/form/div[1]/div/div/div/div"));
    }
}
