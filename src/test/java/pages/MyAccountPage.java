package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class MyAccountPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public MyAccountPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //Links
    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    private WebElement dressesLink;

    //Cart
    @FindBy(xpath = "//*[@id='header']/div[3]/div/div/div[3]/div/a")
    private WebElement cart;

    //Misc
    @FindBy(className = "info-account")
    private WebElement accountWelcomeMsg;

    //Links Business Logic
    public void iClickDressesLink(){
        waitForElementIsClickable(driver, dressesLink);
        dressesLink.click();
    }

    //Cart Business Logic
    public void iClickCart(){
        waitForElementIsClickable(driver, cart);
        cart.click();
    }

    //Misc Business Logic
    public boolean isPageWithAccWelcomeTextDisplayed(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(accountWelcomeMsg.isDisplayed())
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
