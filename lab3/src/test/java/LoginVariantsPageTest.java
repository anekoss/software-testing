import edu.java.LoginVariantsPage;
import edu.java.utils.ConfProperties;
import edu.java.utils.driver.DriversHandler;
import edu.java.utils.driver.InvalidPropertiesException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginVariantsPageTest {

    List<LoginVariantsPage> loginVariantsPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        loginVariantsPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("loginVariants"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            loginVariantsPages.add(new LoginVariantsPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void vkBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.vkBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsVk"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                            .getCurrentUrl())
                                                                                   .getHost());
                }
        );
    }

    @Test
    public void googleBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.googleBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsGoogle"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                                .getCurrentUrl())
                                                                                       .getHost());
                }
        );
    }

    @Test
    public void odnoklassnikiBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.odnoklassnikiBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsOdnoklassniki"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                                       .getCurrentUrl())
                                                                                              .getHost());
                }
        );
    }

    @Test
    public void yandexBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.yandexBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsYandexRu"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                                  .getCurrentUrl())
                                                                                         .getHost());
                }
        );
    }

    @Test
    public void mailBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.mailBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsMailRu"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                                .getCurrentUrl())
                                                                                       .getHost());
                }
        );
    }


    @Test
    public void viberBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.viberBtnClick();
                    loginVariantsPage.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    assertEquals(ConfProperties.getProperty("loginVariantsViber"), URI.create(loginVariantsPage.getWebDriver()
                                                                                                               .getCurrentUrl())
                                                                                      .getHost());
                }
        );
    }

    @Test
    public void emailBtnClickTest() {
        loginVariantsPages.forEach(loginVariantsPage -> {
                    loginVariantsPage.emailBtnClick();
                    loginVariantsPage.waitForUrl(ConfProperties.getProperty("loginEmail"));
                    assertEquals(ConfProperties.getProperty("loginEmail"), loginVariantsPage.getWebDriver()
                                                                                            .getCurrentUrl());
                }
        );
    }
}
