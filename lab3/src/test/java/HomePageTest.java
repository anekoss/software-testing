import edu.java.HomePage;
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

public class HomePageTest {

    List<HomePage> homePageList;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        homePageList = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("homePage"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            homePageList.add(new HomePage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void countriesBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.countriesBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("countries"));
                    assertEquals(ConfProperties.getProperty("countries"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void confidentialityBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("confidentiality"));
                    assertEquals(ConfProperties.getProperty("confidentiality"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void signInBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("loginVariants"));
                    assertEquals(ConfProperties.getProperty("loginVariants"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void genderManBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("registrationDatingPurpose"));
                    assertEquals(ConfProperties.getProperty("registrationDatingPurpose"), homePage.getWebDriver()
                                                                                                  .getCurrentUrl());
                }
        );
    }


    @Test
    public void genderWomanBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("registrationDatingPurpose"));
                    assertEquals(ConfProperties.getProperty("registrationDatingPurpose"), homePage.getWebDriver()
                                                                                                  .getCurrentUrl());
                }
        );
    }

    @Test
    public void citiesBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("cities"));
                    assertEquals(ConfProperties.getProperty("cities"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void journalBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("blog"));
                    assertEquals(ConfProperties.getProperty("blog"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void technologiesBtnClickTest() {
        homePageList.forEach(homePage -> {
                    homePage.confidentialityBtnClick();
                    homePage.waitForUrl(ConfProperties.getProperty("technologies"));
                    assertEquals(ConfProperties.getProperty("technologies"), homePage.getWebDriver().getCurrentUrl());
                }
        );
    }

}
