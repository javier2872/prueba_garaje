package steps_definitions.api_rest;

import io.cucumber.java.en.Then;
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


public class Test_morty_episode_20 {


    @Then("say hi to morty")
    public void say_hi_to_morty() throws IOException, ParseException {
        boolean result = false;
        JSONArray characters = (JSONArray) Hook.getJsonResponse().get("characters");
        for (int i = 0; i <= characters.size(); i++) {
            JSONObject jsonResponse = connect_characters(characters.get(i).toString());
            if (jsonResponse.get("name").toString().contains("Morty")) {
                result = true;
                break;
            }
        }
        Assert.assertTrue(result, "Not fount Morty");
    }

    public JSONObject connect_characters(String aUrl) throws IOException, ParseException {
        JSONObject jsonResponse = null;
        HttpURLConnection con = null;
        URL url = new URL(aUrl);
        con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Language", "en-US");
        con.setUseCaches(false);
        con.setDoOutput(true);
        con.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
        }
        rd.close();
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response.toString());
    }
}
