package API_REQ;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class JsonPlaceholderApiRequests {
	@Test
	public void getRequest() {
		given()
			.get("https://jsonplaceholder.typicode.com/posts")
			.then()
			.statusCode(200)
			.log()
			.all();
	}
	
	@Test
	public void postRequest() {
		JSONObject jo = new JSONObject();
		jo.put("title", "New Post");
		jo.put("body", "This is the body of the new post");
		jo.put("userId", 1);
		given()
			.contentType("application/json")
			.body(jo.toJSONString())
			.when()
			.post("https://jsonplaceholder.typicode.com/posts")
			.then()
			.statusCode(201)
			.log()
			.all();
	}
	
	@Test
	public void putRequest() {
		JSONObject jo = new JSONObject();
		jo.put("title", "Update Post");
		jo.put("body", "This is the updated body of the post");
		jo.put("userId", 1);
		given()
			.contentType("application/json")
			.body(jo.toJSONString())
			.when()
			.put("https://jsonplaceholder.typicode.com/posts/1")
			.then()
			.statusCode(200)
			.log()
			.all();
	}
	@Test
	public void deleteRequest() {
		given()
			.delete("https://jsonplaceholder.typicode.com/posts/1")
			.then()
			.statusCode(200)
			.log()
			.all();
	}

}
