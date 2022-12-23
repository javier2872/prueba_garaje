package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class Page_index {

    private final WebDriver driver;
    private final static By BUTTON_MENU = By.xpath("//header//descendant::*[contains(@class,\"menu-btn__burger\")]");
    private final static By BUTTON_MENU_TALENT = By.xpath("//*[contains(@class, \"menu-desktop\")]//descendant::*[@href=\"/talento/\"]");

    public Page_index(WebDriver aDriver) {
        this.driver = aDriver;
    }


    /**
     * Open the main menu
     */
    public void menu_click() {
        WebElement menu = this.driver.findElement(BUTTON_MENU);
        Utils.waitClickable(menu, this.driver);
        menu.click();
    }
    /**
     * Open section talent
     */
    public void menu_talent_click() {
        Utils.waitVisibility(BUTTON_MENU_TALENT, this.driver);
        WebElement menu_talent = this.driver.findElement(BUTTON_MENU_TALENT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu_talent);
    }
}
