package com.ui.tests.carbonlibre.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='nav-logo']")
    WebElement logoPrincipal;

    @FindBy(css = ".nav-menu-categories-link")
    WebElement menuCategories;

    @FindBy(xpath = "//a[normalize-space()='Deportes y Fitness']")
    WebElement clickFitness;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[1]/article/div/div/div/div/div/div[15]/div/a/div/div/h3")
    WebElement clickBikes;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/section/div[11]/ul/li[1]/a/span[1]")
    WebElement clickPrincipalLocation;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[1]/h1")
    WebElement clickFirstAttributeDisplayed;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[1]/h1")
    WebElement getProductTitle;

    @FindBy(xpath = "//*[@id=\"root-app\"]/div/div[2]/aside/div[2]/span")
    WebElement getSearchedResult;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button[1]")
    WebElement clickCockies;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div/div[2]/button[2]")
    WebElement clickLocationModal;

    private static final Integer PAUSE_TIME = 5000;

    /**
     * Constructor for ProductPage
     * PageFactory is used to initialize the WebElements
     */

    public ProductPage(WebDriver driver) {
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
     * Method to check the Product Page
     */
    public void getProductPage() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickFitness.click();
        setPause();
        clickBikes.click();
        setPause();
        action.moveToElement(clickPrincipalLocation).perform();
        coockiesCLick();
        clickPrincipalLocation.click();
        setPause();
        clickLocationModal.click();
        setPause();
        clickFirstAttributeDisplayed.click();
        setPause();
    }


    /**
     * Method to click some coockies
     */
    private void coockiesCLick() {
        clickCockies.click();
    }

    /**
     * Method to get the final Product title on the page
     */
    public String getProductTitlePage() {
        return getProductTitle.getText();
    }

    /**
     * Method to get the final price of the product on the page
     */
    public boolean getSearchedResultPage() {
        return getSearchedResult.isDisplayed();
    }

    /**
     * Sets a pause on the page
     */
    private void setPause() {
        Actions actions = new Actions(driver);
        actions.pause(PAUSE_TIME).perform();
    }
}
