import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.mortbay.util.ajax.JSON;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class TestScenario01 {
    @Test
    void getCarbonForAllRegions() {
        //Scenario 1 a
        //Response response = RestAssured.get("https://api.carbonintensity.org.uk/regional").path("data.regions.intensity");
       // System.out.println(RestAssured.get("https://api.carbonintensity.org.uk/regional").path("data.regions.intensity","data.regions.shortname").toString());

        //Scenario 1 b
//        String forcast = get("https://api.carbonintensity.org.uk/regional").path("data.regions.intensity.forecast").toString();
//        System.out.println(forcast);
//
//        //Scenario 1 c
        ArrayList<List> interere = get("https://api.carbonintensity.org.uk/regional").path("data.regions.intensity.forecast");
        ArrayList<List> nesto = given().when().contentType(ContentType.JSON).get("https://api.carbonintensity.org.uk/regional").path("data.regions");

        for(List novaLista:nesto){
           // System.out.println(novaLista.get(0));
            //System.out.println(nest);
        }
//        Response response = get("https://api.carbonintensity.org.uk/regional");
//        System.out.println(response.asString());
//        Collections.sort(interere.get(0),Collections.reverseOrder());
//        System.out.println(interere);
}}
//Scenario 1:
//        1. Get carbon intensity for each region
//        2. Get intensity value forecast
//        3. Sort regions for highest to lowest intensity
//        4. Print sorted list in the logs starting with value followed by short name of the region

//
