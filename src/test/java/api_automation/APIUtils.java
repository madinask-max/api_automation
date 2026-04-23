package api_automation;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIUtils {

	public static Response getRequest(String endpoint) {
		return given().when().get(endpoint).then().extract().response();
	}

	public static Response postRequest(String endpoint, String body) {
		return given().header("Content-Type", "application/json").body(body).when().post(endpoint).then().extract()
				.response();
	}

}
