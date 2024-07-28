package API_Demo.RestAssured_Api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API_Project_reqres {
		
		@Test
		public void Register_Successful() {
			RestAssured.baseURI="https://reqres.in/api";
			
			JSONObject q= new JSONObject();
			q.put("email", "eve.holt@reqres.in");
			q.put("password", "pistol");
			
			given().
				contentType("application/json").
				body(q.toJSONString()).
			when().
				post("/register").
			then().
				log().all().
				statusCode(200);
		}
		@Test
		public void Get_Single() {
			RestAssured.baseURI="https://reqres.in/api";
			
				
			given().
				contentType("application/json").
			when().
				get("/users/2").
			then().
				log().all().
				statusCode(200);
		}
		@Test
		public void Get_List() {
			RestAssured.baseURI="https://reqres.in/api";
			
				
			given().
				contentType("application/json").
			when().
				get("/users?page=2").
			then().
				log().all().
				statusCode(200);
		}
}
