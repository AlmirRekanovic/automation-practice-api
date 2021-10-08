import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestScenarion02 {

    void getCarbonForRegion(int region){
      // Response response = RestAssured.given()
               //.pathParam("regionid", "3")
//        ArrayList<List> interere = RestAssured.given()
//               .when()
//               .get("https://api.carbonintensity.org.uk/regional/regionid/{regionid}",region)
//               .path("data.data.generationmix.perc");
//       System.out.println(interere.toString());
    }

        //String ss = get("https://api.carbonintensity.org.uk/regional").path("data.regions.generationmix.perc").toString();
       //Collections.sort(interere.get(0),Collections.reverseOrder());
      //  System.out.println(ss);

        void getFuelNumber(int region){

//
//                            .path("data.data.generationmix.perc");
//

            given().when().get("https://api.carbonintensity.org.uk/regional/regionid/{regionid}",region)
                    .then().body("data.data.generationmix.perc {it.collect}.sum()",equalTo(100));;


    }
    @Test
    void getCssForRegion(){
        getFuelNumber(3);
    }
}
//Scenario 2:
//        1. For each region get carbon intensity
//        2. Assert that generation mix sums to 100
//Scenario 3 (optional):
//        1. For each region get carbon intensity
//        2. For each fuel type list five regions where the generation percentage is the highest