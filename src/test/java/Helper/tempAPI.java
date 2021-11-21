package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class tempAPI {
     RequestSpecification httpRequest;
     Response response;
     String url= "https://reqres.in/";

     @Test
    public void testingAPI(){
         RestAssured.baseURI= url;
         httpRequest=RestAssured.given();
        //httpRequest= RestAssured.given().auth().preemptive().basic("admin", "admin");


         //get request
          response= httpRequest.get("http://localhost:9000");
         //System.out.println(response.getBody().asString());


         //post+put request
         JSONObject parameters= new JSONObject();
         parameters.put("name", "Shani");
       //  parameters.put("job", "Oceanographer");
         parameters.put("job", "QA");

         httpRequest.header("Content-Type","application/json");

         httpRequest.body(parameters.toJSONString());
         //response = httpRequest.post("/api/users");

         response = httpRequest.put("/api/users/2");
     response.prettyPrint();
     }

     @Test
    public void update(){ RestAssured.baseURI= url;
         httpRequest=RestAssured.given();
         //httpRequest= RestAssured.given().auth().preemptive().basic("admin", "admin");


         //get request
         response= httpRequest.delete("/api/users/2");
         //System.out.println(response.getBody().asString());

         response.prettyPrint();

     }


    @Test
    public void register(){
         RestAssured.baseURI= "http://localhost:9000";
        httpRequest=RestAssured.given();
        response= httpRequest.get("/api/login");
        httpRequest= RestAssured.given().auth().preemptive().basic("shani.sultan@gmail.com", "Jerusalem");
        //response= httpRequest.get("/api/register");
        response.prettyPrint();

    }


}
