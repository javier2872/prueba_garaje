package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page_talento {
    private final WebDriver driver;
    private final static By SECTION_JOIN_OUR_TEAM = By.xpath("//*[@class=\"cards-dragger\"]");
    private final static By CARDS_QA_JOBS= By.xpath("//*[@class=\"cards-dragger\"]//descendant::*[contains(text(),\"QA Engineer\")]");
    private final static By MEMBERS_GARAJE= By.xpath("//*[@class=\"member-wrapper\"]");
    private final static By TEAM_LIST = By.xpath("//*[contains(@class, \"team-list\")]");

    public Page_talento(WebDriver aDriver) {
        this.driver = aDriver;
    }


    /**
     * Navigate to join our team
     */
    public void scroll_join_our_team(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.driver.findElement(SECTION_JOIN_OUR_TEAM));

    }
    /**
     * Navigate to join team
     */
    public void scroll_join_team(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", this.driver.findElement(TEAM_LIST));

    }
    /**
     * Check if there is a card with qa job
     * @return Boolean
     */
    public boolean one_QA_job_card(){
        List<WebElement> cards_qa = this.driver.findElements(CARDS_QA_JOBS);
        return cards_qa.size()==1;
    }
    /**
     * Check if Alberto Barrio is member of the team besides CEO
     * @return Boolean
     */
    public boolean alberto_barrio_member_CEO(){
        List<WebElement> member_team = this.driver.findElements(MEMBERS_GARAJE);
        for (int i=0; i<member_team.size();i++){
            if(member_team.get(i).getText().contains("CEO")&&
                    member_team.get(i).getText().toUpperCase().contains("Alberto Barrio".toUpperCase())){
                return true;
            }
        }
        return false;
    }
}
