import edu.java.EnterBirthdayPage;
import edu.java.utils.ConfProperties;
import edu.java.utils.driver.DriversHandler;
import edu.java.utils.driver.InvalidPropertiesException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnterBirthdayPageTest {
    List<EnterBirthdayPage> enterBirthdayPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        enterBirthdayPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationBirthday"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            enterBirthdayPages.add(new EnterBirthdayPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void enterValidBirthdayTest() {
        enterBirthdayPages.forEach(enterBirthdayPage -> {
                    enterBirthdayPage.chooseDay(21);
                    enterBirthdayPage.chooseMonth("май");
                    enterBirthdayPage.chooseYear(1998);
                    enterBirthdayPage.nextBtnClick();
                    enterBirthdayPage.waitForUrl(ConfProperties.getProperty("registrationEmail"));
                    assertEquals(ConfProperties.getProperty("registrationEmail"), enterBirthdayPage.getWebDriver()
                                                                                                   .getCurrentUrl());
                }
        );
    }


    @Test
    public void enterInvalidBirthdayTest() {
        enterBirthdayPages.forEach(enterBirthdayPage -> {
                    enterBirthdayPage.chooseDay(21);
                    enterBirthdayPage.chooseMonth("май");
                    enterBirthdayPage.chooseYear(2010);
                    enterBirthdayPage.nextBtnClick();
                    assertEquals(ConfProperties.getProperty("registrationBirthday"), enterBirthdayPage.getWebDriver()
                                                                                                      .getCurrentUrl());
                }
        );
    }
}
