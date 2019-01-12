package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import steps.base.BaseUtil;

public class CartSteps extends BaseUtil {

    private BaseUtil base;
    private CartPage cartPage;

    public CartSteps(BaseUtil base){
        this.base = base;
    }

    @Then("^Cart page heading is displayed$")
    public void iNavigateToCartPage() throws Throwable {
        cartPage = new CartPage(base);
        Assert.assertTrue(cartPage.isPageWithHeadingTextDisplayed());
    }

    @And("^Cart contains \"([^\"]*)\" dress$")
    public void cartContain(String dressName) throws Throwable {
        Assert.assertEquals(cartPage.cartContainsDressName(),dressName);
    }

    @When("^I click Sign out link$")
    public void iClickSignInLink() throws Throwable {
        cartPage.iClickSignOutLink();
    }
}
