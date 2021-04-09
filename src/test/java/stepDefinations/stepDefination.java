package stepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomepage;
import resource.base;

public class stepDefination extends base {

	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^click on login button to land on secure singnin page$")
	public void click_on_login_button_to_land_on_secure_singnin_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage Landpage=new LandingPage(driver);
		if(Landpage.getPopupSize()>0)
		{
			Landpage.getPopup().click();
		}
		Landpage.getLogin().click();
	}

	/*			// This is suggested by Junit
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(arg1);
		login.getPassword().sendKeys(arg2);
		login.getLogin().click();
	}
*/
/*				// This is suggested by Junit
	@When("^User enters test(\\d+)@gmail\\.com and (\\d+) and logs in$")
	public void user_enters_test_gmail_com_and_and_logs_in(CharSequence[] arg1, CharSequence[] arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(arg1);
		login.getPassword().sendKeys(arg2);
		login.getLogin().click();
	}
*/
				// This is suggested by TidyGherkin Plugin
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage login=new LoginPage(driver);
		login.getEmail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getLogin().click();
    }

	@Then("^verifies that user is successfully logs in or not$")
	public void verifies_that_user_is_successfully_logs_in_or_not() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    PortalHomepage homeportal=new PortalHomepage(driver);
	    //Assert.assertTrue((homeportal.getSearchbox().isDisplayed()));
	    if(homeportal.getLogin().isDisplayed())
	    {
	    	System.out.println("Invalid Credentials");
	    }
	    else
	    {
	    	System.out.println("Login successful");
	    }
	}
	
	@And("^Close Browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }
    
}