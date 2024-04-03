package edu.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RatingPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/header/div[5]/a[1]/div/svg/path[3]")
    public WebElement form;

    public RatingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void formBtnClick() {
        form.click();
    }
}
