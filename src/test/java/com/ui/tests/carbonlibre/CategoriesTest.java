package com.ui.tests.carbonlibre;

import com.ui.tests.carbonlibre.Pages.CategoriesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import static com.ui.tests.carbonlibre.BaseUrl.getBaseUrl;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class CategoriesTest {
    public WebDriver driver;
    public CategoriesPage categoriesPage;

    /**
     * Initialize the WebDriverManager and EdgeDriver.
     * Go to the website and maximize the browser window.
     */

    @BeforeClass
    void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Get the Base URL from the BaseUrl interface
     */

    @BeforeMethod
    void beforeTest() {
        getBaseUrl(driver);
    }

    @Test(description = "Smoke Test")
    void testHomePage(){
        categoriesPage = new CategoriesPage(driver);
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.isLogoDisplayed())
                    .describedAs("Logo is displayed")
                    .isTrue();
        });
    }

    /**
     * Test to verify the "Air Condition" category is displayed and the most searched of them.
     */
    @Test(description = "Regression Test")
    void testAirConditionCategory() {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.airConditionCategory();
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.getAirTitle())
                    .describedAs("Aires Acondicionados Title on the category is displayed")
                    .isEqualTo("Aires Acondicionados");
            softly.assertThat(categoriesPage.getAirSearched())
                    .describedAs("Most Searched about air condition")
                    .isTrue();
        });
    }

    /**
     * Test to verify the "Smartphones" category is displayed and the most searched of them.
     */
    @Test(description = "Regression Test")
    void testSmartphonesCategory() {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.smartphonesCategory();
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.getSmartphonesTitle())
                    .describedAs("Celulares y Smartphones Title on the category is displayed")
                    .isEqualTo("Celulares y Smartphones");
            softly.assertThat(categoriesPage.getSmartphonesSearched())
                    .describedAs("Most Searched about Smartphones")
                    .isTrue();
        });
    }

    /**
     * Test to verify the "Fragrances" category is displayed and the total results on the page.
     */
    @Test(description = "Regression Test")
    void testFragrancesCategory() {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.fragrancesCategory();
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.getFragrancesTitle())
                    .describedAs("Perfumes y Fragancias Title on the category is displayed")
                    .isEqualTo("Perfumes y Fragancias");
            softly.assertThat(categoriesPage.getMostFragancesSearched())
                    .describedAs("Most Searched about Fragances")
                    .isTrue();
        });
    }

    /**
     * Test to verify the "Tools" category is displayed and the total results on the page.
     */
    @Test(description = "Regression Test")
    void testToolsCategory() {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.toolsCategory();
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.getToolsTitle())
                    .describedAs("Herramientas Industriales Title on the category is displayed")
                    .isEqualTo("Herramientas Industriales");
            softly.assertThat(categoriesPage.getMostToolsSearched())
                    .describedAs("Most Tools Searched")
                    .isTrue();
        });
    }

    /**
     * Test to verify the "Baby" category is displayed and the total results on the page.
     */
    @Test(description = "Regression Test")
    void testBabyCategory() {
        categoriesPage = new CategoriesPage(driver);
        categoriesPage.babyCategory();
        assertSoftly(softly -> {
            softly.assertThat(categoriesPage.getBabyTitle())
                    .describedAs("Cuarto del Bebé Title on the category is displayed")
                    .isEqualTo("Cuarto");
            softly.assertThat(categoriesPage.getBabyResults())
                    .describedAs("Total results on the category is displayed")
                    .isTrue();
        });
    }


    @AfterTest
    void tearDown() {
        driver.quit();
    }

}
