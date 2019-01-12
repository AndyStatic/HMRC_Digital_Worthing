package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class AfterSignOutPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public AfterSignOutPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //Sign in
    @FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    private WebElement signInLink;

    //Sign in business login
    public boolean signInLinkIsDisplayed(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(signInLink.isDisplayed())
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
