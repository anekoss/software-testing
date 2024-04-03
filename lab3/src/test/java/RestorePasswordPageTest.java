import edu.java.RestorePasswordPage;
import edu.java.utils.ConfProperties;
import edu.java.utils.driver.DriversHandler;
import edu.java.utils.driver.InvalidPropertiesException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestorePasswordPageTest {

    List<RestorePasswordPage> restorePasswordPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        restorePasswordPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("resetPassword"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            restorePasswordPages.add(new RestorePasswordPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void resetPasswordEmailTest() {
        restorePasswordPages.forEach(restorePasswordPage -> {
            restorePasswordPage.enterEmail("ann1974chernova@gmail.com");
            restorePasswordPage.emailBtnClick();
            restorePasswordPage.waitForUrl(ConfProperties.getProperty("email_success"));
            assertEquals(ConfProperties.getProperty("email_success"), restorePasswordPage.getWebDriver()
                                                                                         .getCurrentUrl());
        });
    }

    @Test
    public void resetPasswordInvalidEmailTest() {
        restorePasswordPages.forEach(restorePasswordPage -> {
            restorePasswordPage.emailBtnClick();
            WebElement element = restorePasswordPage.getEmailError();
            assertEquals(element.getText(), "email введен некорректно");
        });
    }

    @Test
    public void resetPasswordViberTest() {
        restorePasswordPages.forEach(restorePasswordPage -> {
            restorePasswordPage.viberBtnClick();
            restorePasswordPage.waitForUrl(ConfProperties.getProperty("viber_success"));
            assertEquals(ConfProperties.getProperty("viber_success"), restorePasswordPage.getWebDriver()
                                                                                         .getCurrentUrl());
        });
    }

    @Test
    public void resetPasswordNumberTest() {
        restorePasswordPages.forEach(restorePasswordPage -> {
            restorePasswordPage.enterNumber("9871438802");
            restorePasswordPage.numberBtnClick();
            restorePasswordPage.waitForUrl(ConfProperties.getProperty("number_success"));
            assertEquals(ConfProperties.getProperty("number_success"), restorePasswordPage.getWebDriver()
                                                                                          .getCurrentUrl());
        });
    }

    @Test
    public void resetInvalidPasswordNumberTest() {
        restorePasswordPages.forEach(restorePasswordPage -> {
            restorePasswordPage.numberBtnClick();
            WebElement element = restorePasswordPage.getNumberError();
            assertEquals(element.getText(), "mew mew");
            restorePasswordPage.waitForUrl(ConfProperties.getProperty("number_success"));
            assertEquals(ConfProperties.getProperty("number_success"), restorePasswordPage.getWebDriver()
                                                                                          .getCurrentUrl());
        });
    }


}
