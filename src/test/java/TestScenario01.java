import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.*;
import static io.restassured.RestAssured.*;

public class TestScenario01 {

    @Test
    void Scenario1(){

        Response response = given().when().get("https://api.carbonintensity.org.uk/regional");

        List<HashMap<String, Object>> regions = response.path("data[0].regions");
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        List<Map.Entry<String, Integer>> forecastList = null;
        for (HashMap<String, Object> o: regions){
            Response response1 = given()
                    .with()
                    .pathParams("regionid", o.get("regionid").toString())
                    .when()
                    .get("https://api.carbonintensity.org.uk/regional/regionid/{regionid}");

            hashMap.put(o.get("shortname").toString(),response1.path("data[0].data[0].intensity.forecast"));

            forecastList = new ArrayList<>(hashMap.entrySet());

            forecastList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        }

        for(var o: forecastList){
            System.out.println(o.toString());
        }
    }
}
