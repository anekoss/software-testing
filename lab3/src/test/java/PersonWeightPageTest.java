import edu.java.PersonWeightPage;
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

public class PersonWeightPageTest {

    List<PersonWeightPage> personWeightPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        personWeightPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationWeight"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            personWeightPages.add(new PersonWeightPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void weight60BtnClickTest() {
        personWeightPages.forEach(personWeightPage -> {
                    personWeightPage.weight60BtnClick();
                    personWeightPage.waitForUrl(ConfProperties.getProperty("registrationName"));
                    assertEquals(ConfProperties.getProperty("registrationName"), personWeightPage.getWebDriver()
                                                                                                 .getCurrentUrl());
                }
        );
    }

    @Test
    public void weight80BtnClickTest() {
        personWeightPages.forEach(personWeightPage -> {
                    personWeightPage.weight80BtnClick();
                    personWeightPage.waitForUrl(ConfProperties.getProperty("registrationName"));
                    assertEquals(ConfProperties.getProperty("registrationName"), personWeightPage.getWebDriver()
                                                                                                 .getCurrentUrl());
                }
        );
    }

    @Test
    public void weight100BtnClickTest() {
        personWeightPages.forEach(personWeightPage -> {
                    personWeightPage.weight100BtnClick();
                    personWeightPage.waitForUrl(ConfProperties.getProperty("registrationName"));
                    assertEquals(ConfProperties.getProperty("registrationName"), personWeightPage.getWebDriver()
                                                                                                 .getCurrentUrl());
                }
        );
    }

    @Test
    public void weightHighBtnClickTest() {
        personWeightPages.forEach(personWeightPage -> {
                    personWeightPage.weightHighBtnClick();
                    personWeightPage.waitForUrl(ConfProperties.getProperty("registrationName"));
                    assertEquals(ConfProperties.getProperty("registrationName"), personWeightPage.getWebDriver()
                                                                                                 .getCurrentUrl());
                }
        );
    }

    @Test
    public void weightAnyBtnClickTest() {
        personWeightPages.forEach(personWeightPage -> {
                    personWeightPage.weightAnyBtnClick();
                    personWeightPage.waitForUrl(ConfProperties.getProperty("registrationName"));
                    assertEquals(ConfProperties.getProperty("registrationName"), personWeightPage.getWebDriver()
                                                                                                 .getCurrentUrl());
                }
        );
    }
}
