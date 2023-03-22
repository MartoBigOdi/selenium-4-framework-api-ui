package com.ui.tests.carbonlibre.Pages;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class CategoriesPage {
    WebDriver driver;

    // Elements to "Climatización" category
    @FindBy(xpath = "//a[@class='nav-logo']")
    WebElement logoPrincipal;

    @FindBy(css = "header.nav-header.nav-header-plus.ui-navigation-v2:nth-child(1) div.nav-bounds.nav-bounds-with-cart.nav-bounds-with-cp div.nav-area.nav-bottom-area.nav-center-area:nth-child(5) div.nav-menu ul.nav-menu-list > li.nav-menu-item:nth-child(1)")
    WebElement menuCategories;

    @FindBy(xpath = "/html/body/header/div/div[5]/div/ul/li[1]/div/ul/li[6]/a")
    WebElement homeAppliances;

    @FindBy(xpath = "//*[@id=\"special\"]/a/div/div/div[1]/img")
    WebElement clickAirConditioning;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/aside/div/h2")
    WebElement getAirConditioningTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/section/section[1]/div/div/section/div[1]/span/h2")
    WebElement getMostSearchedAirs;

    // Elements to "Smartphones" category
    @FindBy(xpath = "//a[normalize-space()='Tecnología']")
    WebElement mouseOverTechnology;

    @FindBy(xpath = "//ul[@class='nav-categs-detail__categ-list']//a[normalize-space()='Celulares y Smartphones']")
    WebElement clickSmartphones;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/aside/div/h2")
    WebElement getSmartphonesTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/section/section[1]/div/div/section/div[1]/span/h2")
    WebElement getMostSmartphonesSearched;

    // Elements to "Fragrances" category
    @FindBy(xpath = "//a[normalize-space()='Belleza y Cuidado Personal']")
    WebElement clickBeauty;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[16]/div/div/div/div/div[11]/a/div")
    WebElement clickFragrances;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button[1]")
    //static
    WebElement clickCockies;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/aside/div/h2")
    WebElement getFragrancesTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/section/section[1]/div/div/section/div[1]/span/h2")
    WebElement getMostSearchedFragrances;

    // Elements to "Tools" category
    @FindBy(xpath = "//a[normalize-space()='Herramientas']")
    WebElement clickTools;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[10]/div/div/div/div/div[4]/a/div/h3")
    WebElement clickIndustrialTools;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/aside/div/h2")
    WebElement getToolsTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/section/div/section/section[1]/div/div/section/div[1]/span/h2")
    WebElement getToolsSearched;

    // Elements to "Baby" category
    @FindBy(xpath = "//a[normalize-space()='Bebés']")
    WebElement clickBaby;

    @FindBy(xpath = "//div[@class='label']/h3[contains(.,'CUARTO DEL BEBÉ')]")
    WebElement clickBabyProducts;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[1]/h1")
    WebElement getBabyTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[2]/span")
    WebElement getBabyResults;

    private static final Integer PAUSE_TIME = 3000;

    /**
     * Constructor for CategoriesPage
     * PageFactory is used to initialize the WebElements
     */
    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if the logo is displayed
     *
     * @return true if the logo is displayed, false otherwise
     */
    public boolean isLogoDisplayed() {
        return logoPrincipal.isDisplayed();
    }



    /**
     * Method to take a screenshots from the locator
     *
     */
    public void getScreenshotsLocator(String test) throws IOException {
        File source = getAirConditioningTitle.getScreenshotAs(OutputType.FILE);
        File destination = new File("./ScreenshotsUI/Assert Locator Screenshot " + test +".png");
        FileHandler.copy(source, destination);
    }


    /**
     * Method to check "Air Conditioning" category
     */
    public void airConditionCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        homeAppliances.click();
        setPause();
        clickAirConditioning.click();
    }

    /**
     * Method to get the Air Conditioning title of the page
     */
    public String getAirTitle() {
        return getAirConditioningTitle.getText();
    }

    /**
     * Method to get the total number of results of Air Conditioning
     */
    public boolean getAirSearched() {
        return getMostSearchedAirs.isDisplayed();
    }

    /**
     * Method to check "Smartphones" category
     */
    public void smartphonesCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        action.moveToElement(mouseOverTechnology).build().perform();
        setPause();
        clickSmartphones.click();
    }

    /**
     * Method to get the Smartphones title of the page
     */
    public String getSmartphonesTitle() {
        return getSmartphonesTitle.getText();
    }

    /**
     * Method to get the total number of results of Smartphones
     */
    public boolean getSmartphonesSearched() {
        return getMostSmartphonesSearched.isDisplayed();
    }

    /**
     * Method to check "Fragrances" category
     */
    public void fragrancesCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickBeauty.click();
        setPause();
        action.moveToElement(clickFragrances).perform();
        coockiesCLick();
        clickFragrances.click();
    }

    /**
     * Method to get the Fragrances title of the page
     */
    public String getFragrancesTitle() {
        return getFragrancesTitle.getText();
    }

    /**
     * Method to get the total number of results of Fragrances
     */
    public boolean getMostFragancesSearched() {
        return getMostSearchedFragrances.isDisplayed();
    }

    /**
     * Method to check "Tools" category
     */
    public void toolsCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickTools.click();
        setPause();
        action.moveToElement(clickIndustrialTools).perform();
        coockiesCLick();
        clickIndustrialTools.click();
    }

    /**
     * Method to get the Tools title of the page
     */
    public String getToolsTitle() {
        return getToolsTitle.getText();
    }

    /**
     * Method to get the total number of results of Tools
     */
    public boolean getMostToolsSearched() {
        return getToolsSearched.isDisplayed();
    }




    /**
     * Method to check "Baby" category
     */
    public void babyCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickBaby.click();
        setPause();
        action.moveToElement(clickBabyProducts).perform();
        coockiesCLick();
        clickBabyProducts.click();
    }

    /**
     * Method to click some coockies
     */
    private void coockiesCLick() {
        clickCockies.click();
    }

    /**
     * Method to get the Baby title of the page
     */
    public String getBabyTitle() {
        return getBabyTitle.getText();
    }

    /**
     * Method to get the total number of results of Baby
     */
    public boolean getBabyResults() {
        return getBabyResults.isDisplayed();
    }


    /**
     * Sets a pause on the page
     */
    private void setPause() {
        Actions actions = new Actions(driver);
        actions.pause(PAUSE_TIME).perform();
    }
}
