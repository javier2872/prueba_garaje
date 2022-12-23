package steps_definitions;

import org.testng.Assert;
import page_objects.Page_index;
import page_objects.Page_pop_up;
import page_objects.Page_talento;
import properties.Get_value_properties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Test_found_QA_job {

    private final Get_value_properties prop = new Get_value_properties();
    private WebDriver driver;

    @Given("^a guest user in \"([^\"]*)\"$")
    public void a_guest_user_in(String url) {
        this.driver = Hook.getDriver();
        this.driver.get(prop.getUrlIndex());
    }

    @When("user goes to the Talent page")
    public void user_goes_to_the_talent_page() {
        Page_pop_up page_pop_up = new Page_pop_up(this.driver);
        page_pop_up.accept_all_cookies();
        Page_index page_index = new Page_index(this.driver);
        page_index.menu_click();
        page_index.menu_talent_click();
    }

    @When("user goes to Join Our Team section")
    public void user_goes_to_join_our_team_section() {
        Page_talento page_talento = new Page_talento(this.driver);
        page_talento.scroll_join_our_team();
    }

    @Then("there is only one job offer for a QA Engineer")
    public void there_is_only_one_job_offer_for_a_qa_engineer() {
        Page_talento page_talento = new Page_talento(this.driver);
        Assert.assertTrue(page_talento.one_QA_job_card(),"There is not a QA job");
    }

}
