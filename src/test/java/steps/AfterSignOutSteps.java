package steps;

import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.AfterSignOutPage;
import steps.base.BaseUtil;

public class AfterSignOutSteps extends BaseUtil {

    private BaseUtil base;
    private AfterSignOutPage afterSignOutPage;

    public AfterSignOutSteps(BaseUtil base){
        this.base = base;
    }

    @Then("^After Sign out action Sign In link is displayed$")
    public void afterSignOutTextIsDisplayed() throws Throwable {
        afterSignOutPage = new AfterSignOutPage(base);
        Assert.assertTrue(afterSignOutPage.signInLinkIsDisplayed());
    }
}
