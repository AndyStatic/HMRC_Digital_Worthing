package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class DressesPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public DressesPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //Sort
    @FindBy(id = "uniform-selectProductSort")
    private WebElement sortByOverlay;

    @FindBy(xpath = "//*[@id='selectProductSort']/option[3]")
    private WebElement sortByOption3;

    //Select first item in grid
    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img")
    private WebElement firstItemInGrid;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")
    private WebElement firstItemInGridText;

    @FindBy(xpath = "//*[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]")
    private WebElement firstItemInGridAddToCartLink;

    //Misc
    @FindBy(xpath = "//*[@id='categories_block_left']/h2[contains(text(),'Dresses')]")
    private WebElement dressesPageSubHeading;

    //Cart Overlay
    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
    private WebElement proceedToCheckOutBtnOnOverlay;

    //Sort Business Logic
    public void iSelectSortByPriceHighestFirst(){
        waitForVisibility(driver, sortByOverlay);
        sortByOverlay.click();

        waitForVisibility(driver, sortByOption3);
        sortByOption3.click();

        //sort is broken or unknown algorithm
        waitForElementTextEquals(driver, firstItemInGridText,"Printed Chiffon Dress");
    }

    //Select Business Logic
    public void iClickFirstItemInGridAddToCartLink(){
        waitForVisibility(driver, firstItemInGrid);
        Actions builder = new Actions(driver);
        builder.moveToElement(firstItemInGrid).perform();

        waitForElementIsClickable(driver, firstItemInGridAddToCartLink);
        firstItemInGridAddToCartLink.click();
    }

    //Misc Business Logic
    public boolean isPageWithSubHeadingTextDisplayed(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(dressesPageSubHeading.isDisplayed())
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    //Cart Overlay
    public void iClickProceedToCheckOutBtnOnOverlay(){
        waitForElementIsClickable(driver, proceedToCheckOutBtnOnOverlay);
        proceedToCheckOutBtnOnOverlay.click();
    }
}
