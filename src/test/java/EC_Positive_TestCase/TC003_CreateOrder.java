package EC_Positive_TestCase;

import org.testng.annotations.Test;


import EC_Base.Payloads;
import EC_Base.TestBase;
import EC_Pojo.PayloadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class TC003_CreateOrder{


	@Test
	public void createOrder() throws InterruptedException
	{
		RestAssured.baseURI=TestBase.baseURI;

		String createProdutResp=	
				given()
				.log().all()
				.header("Content-Type","application/json")
				.header("Authorization",PayloadData.getAccToken())
				.body(Payloads.createOrderPayloads(PayloadData.getProductId()))
				.when()
				.post("api/ecom/order/create-order")
				.then()
				.log().all()
				.assertThat().statusCode(201)
				.extract().response().asString();
		PayloadData.setOrders(TestBase.rawToJson(createProdutResp).getString("orders[0]"));
		System.out.println("Order : "+PayloadData.getOrders());
	}

}
