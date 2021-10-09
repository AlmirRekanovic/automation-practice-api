import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;

public class TestScenario02 {
    @Test
    void Test1(){

        Response responseRegional = given().when().get("https://api.carbonintensity.org.uk/regional");

        List<HashMap<String, Object>> regions = responseRegional.path("data[0].regions");
        for (HashMap<String, Object> o: regions) {
            Response responseRegion = given()
                    .with()
                    .pathParams("regionid", o.get("regionid").toString())
                    .when()
                    .get("https://api.carbonintensity.org.uk/regional/regionid/{regionid}");

            List<HashMap<String, Object>> generationMix = responseRegion.path("data[0].data[0].generationmix");
            float s = (float) 0;
            Float sum=Float.valueOf(0);
            for (HashMap<String, Object> obj : generationMix) {
                var perc = obj.get("perc");
                if (sum.getClass() == perc.getClass()) {
                    sum = sum + (Float) perc;
                }
                else{
                    int percI = (int) perc;
                    sum = sum + (float) percI;
                }
            }
            int convertedSum = Math.round(sum);
            if(convertedSum == 100){
                System.out.println("For "+o.get("shortname")+" perc sum is "+convertedSum);
            }
            else{
                System.out.println("Perc is higher then 100");
            }
        }
    }
}