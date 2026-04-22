package api_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.TestData;

public class APITest extends BaseTest {

	@Test
	public void testGetPosts() {
		Response response = APIUtils.getRequest("/posts");

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertTrue(response.getTime() < 3000);
	}

	@Test
	public void testGetSinglePost() {
		Response response = APIUtils.getRequest("/posts/1");

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getInt("id"), 1);
	}

	@Test
	public void testCreatePost() {
		String body = TestData.createPostBody();

		Response response = APIUtils.postRequest("/posts", body);

		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("title"), "Test Title");
	}
}
