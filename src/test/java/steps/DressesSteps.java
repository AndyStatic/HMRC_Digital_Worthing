package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.DressesPage;
import steps.base.BaseUtil;

public class DressesSteps extends BaseUtil {

    private BaseUtil base;
    private DressesPage dressesPage;

    public DressesSteps(BaseUtil base){
        this.base = base;
    }

    @Then("^Dresses page subheading is displayed$")
    public void iNavigateToCreateNewAccountPage() throws Throwable {
        dressesPage = new DressesPage(base);
        Assert.assertTrue(dressesPage.isPageWithSubHeadingTextDisplayed());
    }

    @When("^I select Sort by Price: Highest First$")
    public void iSelectStateForNewAccount() throws Throwable {
        dressesPage.iSelectSortByPriceHighestFirst();
    }

    @And("^I click first item in grid Add To Cart link$")
    public void iClickSignInLink() throws Throwable {
        dressesPage.iClickFirstItemInGridAddToCartLink();
    }

    @When("^I click Proceed To Checkout btn on overlay")
    public void iClickProceedToCheckOutBtnOnOverlay() throws Throwable {
        dressesPage.iClickProceedToCheckOutBtnOnOverlay();
    }
}
