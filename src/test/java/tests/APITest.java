package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import core.ApiDetails;
import io.restassured.response.Response;
import models.request.CreatePostRequest;
import services.PostService;
import utils.APIUtils;
import utils.ExtentTestManager;

public class APITest extends BaseTest {

	@Test

	public void testGetPosts() {
		System.out.println(">>> API CALL STARTED GETTT");
		Response response = APIUtils.getRequest("/posts");

		System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.getTime() < 3000);
	}

	@Test
	public void testGetSinglePost() {

		System.out.println(">>> API CALL STARTED  GET 2222222");
		Response response = APIUtils.getRequest("/posts/1");

		System.out.println(response.getBody().asString());

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("id"), 1);
	}

	@Test
	public void testCreatePost() {

		ExtentTestManager.getTest().info("Starting testCreatePost");

		PostService service = new PostService();

		CreatePostRequest req = new CreatePostRequest();
		req.title = "Test Title";
		req.body = "Test Body";
		req.userId = 1;

		ExtentTestManager.getTest().info("Request Payload: " + req);

		ApiDetails response = service.createPost(req);

		ExtentTestManager.getTest().info("Response: " + response.getResponse().asString());

		Assert.assertEquals(response.getStatusCode(), 201);

		ExtentTestManager.getTest().pass("Test Passed Successfully");

		System.out.println(">>> API CALL STARTED POSTTTT");

		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
