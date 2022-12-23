package steps_definitions.api_rest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.time.Duration;


public class Hook {

    private static HttpURLConnection con = null;

    private static JSONObject jsonResponse = null;

    public static HttpURLConnection getCon() {
        return con;
    }
    public static void setCon(HttpURLConnection aCon) {
        con = aCon;
    }

    public static JSONObject getJsonResponse() {
        return jsonResponse;
    }

    public static void setJsonResponse(JSONObject aJsonResponse) {
        jsonResponse = aJsonResponse;
    }

    @After("@API")
    public void teardown(Scenario aScenario) {
        if (getCon() != null) {
            getCon().disconnect();
        }
    }

}