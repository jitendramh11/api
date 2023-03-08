package EC_Positive_TestCase;

import org.testng.annotations.Test;

import EC_Pojo.PayloadData;
import EC_Base.Payloads;
import EC_Base.TestBase;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class TC004_ViewOrder{


	@Test
	public void viewOrderDetails() throws InterruptedException
	{
		 RestAssured.baseURI=TestBase.baseURI;
         given()
		.header("Authorization",PayloadData.getAccToken())
		.queryParam("id", PayloadData.getOrders())
		.when()
		.get("api/ecom/order/get-orders-details")
		.then()
		.log().all()
		.assertThat().statusCode(200);

	}

}
