import edu.java.SelectDatingPurposePage;
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

public class SelectDatingPurposePageTest {

    List<SelectDatingPurposePage> selectDatingPurposePages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        selectDatingPurposePages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationDatingPurpose"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            selectDatingPurposePages.add(new SelectDatingPurposePage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void seriousRelationshipBtnClinkTest() {
        selectDatingPurposePages.forEach(selectDatingPurposePage -> {
                    selectDatingPurposePage.seriousRelationshipBtnClink();
                    selectDatingPurposePage.waitForUrl(ConfProperties.getProperty("registrationHeight"));
                    assertEquals(ConfProperties.getProperty("registrationHeight"), selectDatingPurposePage.getWebDriver()
                                                                                                          .getCurrentUrl());
                }
        );
    }

    @Test
    public void friendlyRelationshipBtnClinkTest() {
        selectDatingPurposePages.forEach(selectDatingPurposePage -> {
                    selectDatingPurposePage.friendlyRelationshipBtnClink();
                    selectDatingPurposePage.waitForUrl(ConfProperties.getProperty("registrationHeight"));
                    assertEquals(ConfProperties.getProperty("registrationHeight"), selectDatingPurposePage.getWebDriver()
                                                                                                          .getCurrentUrl());
                }
        );
    }

    @Test
    public void flirtBtnClinkTest() {
        selectDatingPurposePages.forEach(selectDatingPurposePage -> {
                    selectDatingPurposePage.flirtBtnClink();
                    selectDatingPurposePage.waitForUrl(ConfProperties.getProperty("registrationHeight"));
                    assertEquals(ConfProperties.getProperty("registrationHeight"), selectDatingPurposePage.getWebDriver()
                                                                                                          .getCurrentUrl());
                }
        );
    }

    @Test
    public void simplyBtnClinkTest() {
        selectDatingPurposePages.forEach(selectDatingPurposePage -> {
                    selectDatingPurposePage.simplyBtnClink();
                    selectDatingPurposePage.waitForUrl(ConfProperties.getProperty("registrationHeight"));
                    assertEquals(ConfProperties.getProperty("registrationHeight"), selectDatingPurposePage.getWebDriver()
                                                                                                          .getCurrentUrl());
                }
        );
    }

}
