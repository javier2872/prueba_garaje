package steps_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page_objects.Page_talento;

public class Test_found_CEO {

    @When("user goes to Team section")
    public void user_goes_to_team_section() {
        Page_talento page_talento = new Page_talento(Hook.getDriver());
        page_talento.scroll_join_team();
    }

    @Then("the first member is Alberto Barrio, our beloved CEO")
    public void the_first_member_is_alberto_barrio_our_beloved_ceo() {
        Page_talento page_talento = new Page_talento(Hook.getDriver());
        Assert.assertTrue(page_talento.alberto_barrio_member_CEO(), "Not found Alberto Barrio as CEO");
    }
}
