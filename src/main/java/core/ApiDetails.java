package core;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

public class ApiDetails {

	
	 private RequestSpecification request;
	    private Response response;
	    private Object payload;

	    public ApiDetails(RequestSpecification request, Response response, Object payload) {
	        this.request = request;
	        this.response = response;
	        this.payload = payload;
	    }

	    public Response getResponse() {
	        return response;
	    }

	    public int getStatusCode() {
	        return response.getStatusCode();
	    }
    
    
}
