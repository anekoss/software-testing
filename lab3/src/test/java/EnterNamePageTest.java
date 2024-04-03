import edu.java.EnterNamePage;
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

public class EnterNamePageTest {


    List<EnterNamePage> enterNamePages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        enterNamePages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationName"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            enterNamePages.add(new EnterNamePage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }

    @Test
    public void enterValidNameTest() {
        enterNamePages.forEach(enterNamePage -> {
                    enterNamePage.enterName("Егор");
                    enterNamePage.nextBtnClick();
                    enterNamePage.waitForUrl(ConfProperties.getProperty("registrationBirthday"));
                    assertEquals(ConfProperties.getProperty("registrationBirthday"), enterNamePage.getWebDriver()
                                                                                                  .getCurrentUrl());
                }
        );
    }

    @Test
    public void enterInvalidNameTest() {
        enterNamePages.forEach(enterNamePage -> {
                    enterNamePage.nextBtnClick();
                    WebElement element = enterNamePage.getError();
                    assertEquals(element.getText(), "Укажите свое имя");
                }
        );
    }

}
