package api_automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.*;
import java.util.stream.Collectors;
public class ApiTest {

	public static void main(String[] args) {

        // 🔹 Step 1: Hit API (replace with actual endpoint)
        Response response = RestAssured
                .given()
                .when()
                .get("https://your-api-endpoint.com");

        // 🔹 Step 2: Convert response to List of Maps
        List<Map<String, Object>> dataList = response.jsonPath().getList("");

        // 🔹 Step 3: Extract id & version
        List<Map<String, Object>> extractedList = dataList.stream()
                .map(item -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", item.get("id"));
                    map.put("version", Double.parseDouble(item.get("version").toString()));
                    return map;
                })
                .collect(Collectors.toList());

        // 🔹 Step 4: Sort by version
        List<Map<String, Object>> sortedList = extractedList.stream()
                .sorted(Comparator.comparing(m -> (Double) m.get("version")))
                .collect(Collectors.toList());

        // 🔹 Step 5: Print result
        sortedList.forEach(System.out::println);
    }
}
	
	

