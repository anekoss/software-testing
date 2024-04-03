import edu.java.CityListPage;
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

public class CityListPageTest {

    List<CityListPage> cityListPages;

    @BeforeEach
    public void setUp() {
        DriversHandler.initDrivers();
        cityListPages = new ArrayList<>();
        if (DriversHandler.isDriversEmpty()) throw new InvalidPropertiesException();
        DriversHandler.drivers.parallelStream().forEach(driver -> {
            driver.get(ConfProperties.getProperty("cities"));
            driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
            cityListPages.add(new CityListPage(driver));
            driver.manage().window().maximize();
        });
    }


    @AfterEach
    public void close() {
        DriversHandler.closeDrivers();
    }


    @Test
    public void moscowBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.moscowBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("moscow"));
                    assertEquals(ConfProperties.getProperty("moscow"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void saintPetersburgBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.saintPetersburgBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("saintPetersburg"));
                    assertEquals(ConfProperties.getProperty("saintPetersburg"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void novosibirskBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.novosibirskBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("novosibirsk"));
                    assertEquals(ConfProperties.getProperty("novosibirsk"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void ekaterinburgBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.ekaterinburgBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("ekaterinburg"));
                    assertEquals(ConfProperties.getProperty("ekaterinburg"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void nizhniyNovgorodBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.nizhniyNovgorodBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("nizhniyNovgorod"));
                    assertEquals(ConfProperties.getProperty("nizhniyNovgorod"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test

    public void kazanBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.kazanBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("kazan"));
                    assertEquals(ConfProperties.getProperty("kazan"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void omskBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.omskBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("omsk"));
                    assertEquals(ConfProperties.getProperty("omsk"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void samaraBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.samaraBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("samara"));
                    assertEquals(ConfProperties.getProperty("samara"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void chelyabinskBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.chelyabinskBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("chelyabinsk"));
                    assertEquals(ConfProperties.getProperty("chelyabinsk"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void rostovOnDonBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.rostovOnDonBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("rostovOnDon"));
                    assertEquals(ConfProperties.getProperty("rostovOnDon"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void ufaBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.ufaBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("ufa"));
                    assertEquals(ConfProperties.getProperty("ufa"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void permBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.permBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("perm"));
                    assertEquals(ConfProperties.getProperty("perm"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void volgogradBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.volgogradBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("volgograd"));
                    assertEquals(ConfProperties.getProperty("volgograd"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void krasnoyarskBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.krasnoyarskBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("krasnoyarsk"));
                    assertEquals(ConfProperties.getProperty("krasnoyarsk"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

    @Test
    public void voronezhBtnClickTest() {
        cityListPages.forEach(cityListPage -> {
                    cityListPage.voronezhBtnClick();
                    cityListPage.waitForUrl(ConfProperties.getProperty("voronezh"));
                    assertEquals(ConfProperties.getProperty("voronezh"), cityListPage.getWebDriver().getCurrentUrl());
                }
        );
    }

}
