package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

public class HomePage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public HomePage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    @FindBy(className = "login")
    private WebElement signInLink;

    //Business Logic

    public void iClickSignInLink(){
        waitForElementIsClickable(driver, signInLink);
        signInLink.click();
    }

}
