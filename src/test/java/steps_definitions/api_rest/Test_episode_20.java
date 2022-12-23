package steps_definitions.api_rest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Test_episode_20 {

    @Given("^a call \"([^\"]*)\"$")
    public void a_call(String aUrl) throws IOException {
        URL url = new URL(aUrl);
        Hook.setCon((HttpURLConnection) url.openConnection());
        Hook.getCon().setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        Hook.getCon().setRequestProperty("Content-Language", "en-US");
        Hook.getCon().setUseCaches(false);
        Hook.getCon().setDoOutput(true);
    }

    @When("send a request HTTP GET")
    public void send_a_request_http_get() throws IOException {
        Hook.getCon().setRequestMethod("GET");
        int response_code = Hook.getCon().getResponseCode();
        Assert.assertEquals(HttpURLConnection.HTTP_OK, response_code, "GET request did not work");


    }

    @Then("check datas of the response")
    public void check_datas_of_the_response() throws IOException, ParseException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(Hook.getCon().getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
        }
        rd.close();
        JSONParser parser = new JSONParser();
        Hook.setJsonResponse((JSONObject) parser.parse(response.toString()));
        Assert.assertNotNull(Hook.getJsonResponse().get("id"), "not found field id");
        Assert.assertNotNull(Hook.getJsonResponse().get("name"), "not found field name");
        Assert.assertNotNull(Hook.getJsonResponse().get("air_date"), "not found field air_date");
        Assert.assertNotNull(Hook.getJsonResponse().get("episode"), "not found field episode");
        Assert.assertNotNull(Hook.getJsonResponse().get("characters"), "not found field characters");
        Assert.assertNotNull(Hook.getJsonResponse().get("url"), "not found field url");
        Assert.assertNotNull(Hook.getJsonResponse().get("created"), "not found field created");
    }

    @Then("appear {int} characters")
    public void appear_characters(Integer number) {
        JSONArray characters = (JSONArray) Hook.getJsonResponse().get("characters");
        Assert.assertEquals(characters.size(), number, "The size is not correct");
    }

    @Then("field created follows ISO-8601")
    public void field_created_follows_iso() throws java.text.ParseException {
        String date_created = (String) Hook.getJsonResponse().get("created");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("CET"));
        Assert.assertNotNull(sdf.parse(date_created), "Date doesn't have the correct format");
    }

}
