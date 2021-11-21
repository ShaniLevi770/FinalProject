package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;


public class APIActions extends CommonOps {

    @Step ("Get Data From Server")
    public static Response get(String AppValues) {
        response = httpRequest.get(AppValues);
       // response.prettyPrint();
        return response;
    }

    @Step ("Extract Value From Json Format")
    public static String extractFromJson(Response response, String path){
        jp=response.jsonPath();
        return jp.get(path).toString();
    }


    @Step ("Post Data To Server")
        public static void post(JSONObject parameters, String resource) {
        httpRequest.header("Content-Type", "application/json" );
        httpRequest.body(parameters.toJSONString());
        response = httpRequest.post(resource);
       // response.prettyPrint();

    }

    @Step ("Update Data In Server")
    public static void update(JSONObject parameters, String resource) {
        httpRequest.header("Content-Type", "application/json" );
        httpRequest.body(parameters.toJSONString());
        response = httpRequest.put(resource);
       // response.prettyPrint();

    }

    @Step ("Delete Data In Server")
    public static void delete(String resource) {
        response = httpRequest.delete(resource);
       // response.prettyPrint();

    }
}
