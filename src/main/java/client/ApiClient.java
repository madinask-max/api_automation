package client;

import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import utils.ConfigManager;

import static io.restassured.RestAssured.*;

public class ApiClient {
	

	    public static FilterableRequestSpecification getRequest() {
	        return (FilterableRequestSpecification) given()
	                .baseUri(ConfigManager.get("base.url"))
	                .header("Content-Type", "application/json")
	                .filter(new RequestLoggingFilter())   
	                .filter(new ResponseLoggingFilter());
	    }
	}
	
