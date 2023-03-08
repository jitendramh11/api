package EC_Base;



import io.restassured.path.json.JsonPath;

public class TestBase {
	
	public static String baseURI="https://rahulshettyacademy.com/";
	
	

	public static JsonPath rawToJson(String response)
	{
          return new JsonPath(response);
	}
	

}
