package EC_Positive_TestCase;

import org.testng.annotations.Test;

import EC_Pojo.PayloadData;
import EC_Base.Payloads;
import EC_Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class TC005_DeleteProduct{


	@Test
	public void deleteProduct() throws InterruptedException
	{
		RestAssured.baseURI=TestBase.baseURI;
		given()
		.header("Authorization",PayloadData.getAccToken())		
		.when()
		.delete("api/ecom/product/delete-product/{pdoductId}",PayloadData.getProductId())
		.then()
		.log().all()
		.assertThat().statusCode(200);	
	}

}
