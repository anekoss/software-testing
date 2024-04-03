import edu.java.PersonHeightPage;
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

public class PersonHeightPageTest {

    List<PersonHeightPage> personHeightPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        personHeightPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationHeight"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            personHeightPages.add(new PersonHeightPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void height170BtnClick() {
        personHeightPages.forEach(personHeightPage -> {
                    personHeightPage.height170BtnClick();
                    personHeightPage.waitForUrl(ConfProperties.getProperty("registrationWeight"));
                    assertEquals(ConfProperties.getProperty("registrationWeight"), personHeightPage.getWebDriver()
                                                                                                   .getCurrentUrl());
                }
        );
    }

    @Test
    public void height190BtnClickTest() {
        personHeightPages.forEach(personHeightPage -> {
                    personHeightPage.height190BtnClick();
                    personHeightPage.waitForUrl(ConfProperties.getProperty("registrationWeight"));
                    assertEquals(ConfProperties.getProperty("registrationWeight"), personHeightPage.getWebDriver()
                                                                                                   .getCurrentUrl());
                }
        );
    }

    @Test
    public void heightHighBtnClickTest() {
        personHeightPages.forEach(personHeightPage -> {
                    personHeightPage.heightHighBtnClick();
                    personHeightPage.waitForUrl(ConfProperties.getProperty("registrationWeight"));
                    assertEquals(ConfProperties.getProperty("registrationWeight"), personHeightPage.getWebDriver()
                                                                                                   .getCurrentUrl());
                }
        );
    }

    @Test
    public void heightAnyBtnClickTest() {
        personHeightPages.forEach(personHeightPage -> {
                    personHeightPage.heightAnyBtnClick();
                    personHeightPage.waitForUrl(ConfProperties.getProperty("registrationWeight"));
                    assertEquals(ConfProperties.getProperty("registrationWeight"), personHeightPage.getWebDriver()
                                                                                                   .getCurrentUrl());
                }
        );
    }


}
