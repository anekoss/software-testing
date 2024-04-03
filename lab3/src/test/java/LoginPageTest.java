import edu.java.LoginPage;
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

public class LoginPageTest {
    List<LoginPage> loginPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        loginPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("loginEmail"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            loginPages.add(new LoginPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void loginWithValidData() {
        loginPages.forEach(loginPage -> {
            loginPage.enterLogin("ann1974chernova@gmail.com");
            loginPage.enterPassword("T9r38wnz");
            loginPage.signInBtnClick();
            loginPage.waitForUrl(ConfProperties.getProperty("login_success"));
            assertEquals(ConfProperties.getProperty("login_success"), loginPage.getWebDriver().getCurrentUrl());
        });
    }

    @Test
    public void loginWithInvalidPassword() {
        loginPages.forEach(loginPage -> {
            loginPage.enterLogin("ann1974chernova@gmail.com");
            loginPage.signInBtnClick();
            loginPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement element = loginPage.getPasswordError();
            assertEquals(element.getText(), "Укажите свой пароль");
        });
    }

    @Test
    public void loginWithInvalidLogin() {
        loginPages.forEach(loginPage -> {
            loginPage.enterPassword("T9r38wnz");
            loginPage.signInBtnClick();
            loginPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement element = loginPage.getLoginError();
            assertEquals(element.getText(), "Укажите свой адрес электронной почты или логин");
        });
    }

    @Test
    public void resetPasswordTest(){
        loginPages.forEach(loginPage -> {
            loginPage.forgetPasswordBtnClick();
            assertEquals(ConfProperties.getProperty("resetPassword"), loginPage.getWebDriver()
                                                                                              .getCurrentUrl());
        });
    }


}
