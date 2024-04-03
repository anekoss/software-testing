import edu.java.FinalStepPage;
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

public class FinalStepPageTest {
    List<FinalStepPage> finalStepPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        finalStepPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("registrationEmail"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            finalStepPages.add(new FinalStepPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }

    @Test
    public void enterValidEmailTest() {
        finalStepPages.forEach(finalStepPage -> {
                    finalStepPage.inputEmail("ann1974ch@gmail.com");
                    finalStepPage.registrationBtnClick();
                    finalStepPage.waitForUrl(ConfProperties.getProperty("verification"));
                    assertEquals(ConfProperties.getProperty("verification"), finalStepPage.getWebDriver().getCurrentUrl());
                }
        );
    }


    @Test
    public void enterInvalidEmailTest() {
        finalStepPages.forEach(finalStepPage -> {
                    finalStepPage.inputEmail("ann1974erno");
                    finalStepPage.registrationBtnClick();
                    WebElement element = finalStepPage.getError();
                    assertEquals(element.getText(), "Укажите свою почту");
                }
        );
    }

    @Test
    public void enterEmptyEmailTest() {
        finalStepPages.forEach(finalStepPage -> {
                    finalStepPage.registrationBtnClick();
                    WebElement element = finalStepPage.getError();
                    assertEquals(element.getText(), "Укажите свою почту");
                }
        );
    }
}
