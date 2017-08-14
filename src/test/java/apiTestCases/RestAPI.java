package apiTestCases;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by NEERAJ on 7/9/2017.
 */
public class RestAPI {

    @Test
    public void testVariantPage() {
        RestAssured.baseURI = "http://carsbikes_api3.11.com:8081";

        Response response = given().
                header("X-Quikr-Client", "cars").
                param("brand", "Honda").
                param("model", "City").
                param("variant", "SV Diesel").
                when().
                get("/cnb/newcars/variantPage").
                then().
                statusCode(200).
                body("VariantPageResponse.VariantPage.similarityScore", notNullValue()).
                body("VariantPageResponse.VariantPage.design_and_dimensions.seating_capacity", notNullValue()).
                extract().response();

        HashMap<String, String> engine = response.path("VariantPageResponse.VariantPage.engine");


    }
}