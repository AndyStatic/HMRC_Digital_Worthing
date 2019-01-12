package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

public class AuthenticationPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public AuthenticationPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //CREATE AN ACCOUNT
    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateButton;

    //ALREADY REGISTERED?
    @FindBy(id = "email")
    private WebElement emaiInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;


    //CREATE AN ACCOUNT Business Logic
    public void iEnterEmailForCreateAnAccount(String email){
        waitForVisibility(driver, emailCreateInput);
        emailCreateInput.sendKeys(email);
    }

    public void iPressSubmitForCreateAnAccount(){
        waitForElementIsClickable(driver, submitCreateButton);
        submitCreateButton.submit();
    }

    //ALREADY REGISTERED? Business Logic
    public void iEnterEmailForRegisteredUser(String email){
        waitForVisibility(driver, emaiInput);
        emaiInput.sendKeys(email);
    }

    public void iEnterPasswordForRegisteredUser(String password){
        waitForVisibility(driver, passwdInput);
        passwdInput.sendKeys(password);
    }

    public void iPressSubmitForRegisteredUser(){
        waitForElementIsClickable(driver, submitLoginButton);
        submitLoginButton.click();
    }

}
