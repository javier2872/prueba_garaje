package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class Page_pop_up {
    private final WebDriver driver;
    private final static By COOKIES = By.xpath("//*[@id=\"cookiefirst-custom-banner\"]");
    private final static By ACCEPT_ALL_COOKIES = By.name("acceptAll");

    public Page_pop_up(WebDriver aDriver) {
        this.driver = aDriver;
    }

    /**
     * Find the cookies pop-up and click to accept all of them
     */
    public void accept_all_cookies() {
        this.driver.findElement(COOKIES).isDisplayed();
        WebElement button_accept_all = this.driver.findElement(ACCEPT_ALL_COOKIES);
        Utils.waitClickable(button_accept_all, this.driver);
        button_accept_all.click();
    }
}
