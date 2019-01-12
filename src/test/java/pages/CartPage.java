package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class CartPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public CartPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //Dress in cart
    @FindBy(xpath = "//*[@id='cart_summary']/tbody/tr/td[2]/p/a")
    private WebElement dressInCart;

    //Misc
    @FindBy(xpath = "//h1[contains(text(),'Shopping-cart summary')]")
    private WebElement cartPageHeading;

    //Logout
    @FindBy(className = "logout")
    private WebElement logoutLink;

    //Dress in cart Business Logic
    public String cartContainsDressName(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(cartPageHeading.isDisplayed())
                return dressInCart.getText();
            else
                return "Element not found";
        }
        catch(Exception e)
        {
            return "Element not found";
        }
    }

    //Misc Business Logic
    public boolean isPageWithHeadingTextDisplayed(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(cartPageHeading.isDisplayed())
                return true;
            else
                return false;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    //Logout Business Logic
    public void iClickSignOutLink(){
        waitForElementIsClickable(driver, logoutLink);
        logoutLink.click();
    }

}
