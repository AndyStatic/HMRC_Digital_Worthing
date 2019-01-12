package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.ExplicitWaits;
import steps.base.BaseUtil;

import java.util.concurrent.TimeUnit;

public class CreateNewAccountPage extends ExplicitWaits {

    WebDriver driver;
    WebDriverWait explicitWait;

    public CreateNewAccountPage(BaseUtil base){
        //Initialize the page object
        PageFactory.initElements(base.driver, this);
        driver = base.driver;
        explicitWait = base.explicitWait;
    }

    //YOUR PERSONAL INFORMATION
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    //YOUR ADDRESS
    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "uniform-id_state")
    private WebElement stateSelectorOverlay;

    @FindBy(xpath = "//*[@id='id_state']/option[2]")
    private WebElement stateOption2;

    @FindBy(id = "id_state")
    private WebElement stateSelector;

    @FindBy(id = "postcode")
    private WebElement postCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;

    //Misc
    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    @FindBy(xpath = "//*[@id='noSlide']/h1[contains(text(),'Create an account')]")
    private WebElement CreateNewAccPageHeading;


    //YOUR PERSONAL INFORMATION Business Logic
    public void iEnterFirstNameForCreateAnAccount(String firstName){
        waitForVisibility(driver, firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    public void iEnterLastNameForCreateAnAccount(String lastName){
        waitForVisibility(driver, lastNameInput);
        lastNameInput.sendKeys(lastName);
    }
    public void iEnterPasswordForCreateAnAccount(String password){
        waitForVisibility(driver, passwordInput);
        passwordInput.sendKeys(password);
    }

    //YOUR ADDRESS Business Logic
    public void iEnterAddress1ForCreateAnAccount(String address1){
        waitForVisibility(driver, addressInput);
        addressInput.sendKeys(address1);
    }

    public void iEnterCityForCreateAnAccount(String city){
        waitForVisibility(driver, cityInput);
        cityInput.sendKeys(city);
    }

    public void iSelectStateForCreateAnAccount(String state){
        waitForVisibility(driver, stateSelectorOverlay);
        stateSelectorOverlay.click();

        waitForVisibility(driver, stateOption2);
        stateOption2.click();

        //waitForVisibility(driver, stateSelector);
        //Select dropdown = new Select(stateSelector);
        //dropdown.selectByValue(state);
    }

    public void iEnterPostCodeForCreateAnAccount(String postCode){
        waitForVisibility(driver, postCodeInput);
        postCodeInput.sendKeys(postCode);
    }

    public void iEnterMobilePhoneForCreateAnAccount(String mobilePhone){
        waitForVisibility(driver, mobilePhoneInput);
        mobilePhoneInput.sendKeys(mobilePhone);
    }

    //Misc
    public void iPressSubmitAccountButton(){
        waitForElementIsClickable(driver, submitAccountButton);
        submitAccountButton.click();
    }

    public boolean isPageWithHeadingTextDisplayed(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try
        {
            if(CreateNewAccPageHeading.isDisplayed())
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
