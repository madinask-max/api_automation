package services;

import client.ApiClient;
import constants.Endpoints;
import core.ApiDetails;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import models.request.CreatePostRequest;

public class PostService {

	
	 public ApiDetails createPost(CreatePostRequest requestBody) {

	        FilterableRequestSpecification request = ApiClient.getRequest();
	        request.body(requestBody);

//	        Response response = request.post(Endpoints.CREATE_POST);
	        
	        Response response = request
	                .log().all()   // 🔥 prints full request
	                .post(Endpoints.CREATE_POST);

	        response.then().log().all();   // 🔥 prints full response

	        return new ApiDetails(request, response, requestBody);
	    }
	
}
