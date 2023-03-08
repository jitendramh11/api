package EC_Negative_TestCase;

import org.testng.annotations.Test;


import EC_Base.Payloads;
import EC_Base.TestBase;
import EC_Pojo.LoginCredentials;
import EC_Pojo.PayloadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class TC001_AccessToken{


	@Test
	public void getAccessToken() throws InterruptedException
	{
		
		RestAssured.baseURI=TestBase.baseURI;
		LoginCredentials lC=new LoginCredentials();		

		String loginResp=	
				given()
				.header("Content-Type","application/json")
				.body(Payloads.loginPayloads(lC.getUserName(),lC.getPassword()))
				.when()
				.post("api/ecom/auth/login")
				.then()
				.log().all()
				.assertThat().statusCode(201)
				.extract().response().body().asString();

		PayloadData.setAccToken(TestBase.rawToJson(loginResp).getString("token"));
		PayloadData.setUserId(TestBase.rawToJson(loginResp).getString("userId"));

	}

}
