package files;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class ReUsableMethods {

public static JSONObject rawToJson(String addBookResponse) {
    JSONObject jsonResponse = new JSONObject(addBookResponse);
    return jsonResponse;
}
}