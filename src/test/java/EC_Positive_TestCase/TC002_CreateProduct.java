package EC_Positive_TestCase;

import org.testng.annotations.Test;


import EC_Base.Payloads;
import EC_Base.TestBase;
import EC_Pojo.PayloadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;


public class TC002_CreateProduct{


	@Test
	public void createProduct() throws InterruptedException
	{
		RestAssured.baseURI=TestBase.baseURI;
        String createProductResp=
				given()
				.log().all()
				.header("Content-Type","multipart/form-data")
				.header("Authorization",PayloadData.getAccToken())
				.formParam("productName", "Raymond")
				.formParam("productAddedBy", PayloadData.getUserId())
				.formParam("productCategory", "fashion")
				.formParam("productSubCategory", "shirts")
				.formParam("productPrice", "11500")
				.formParam("productDescription", "Raymond Originals")
				.formParam("productFor", "women")
				.multiPart("productImage", new File("E:\\Documents\\myphoto.jpg"))
				.when()
				.post("api/ecom/product/add-product")
				.then()
				.log().all()
				.assertThat().statusCode(201)
				.extract().response().asString();

		PayloadData.setProductId(TestBase.rawToJson(createProductResp).getString("productId"));
		System.out.println("ProdId : "+PayloadData.getProductId());

	}

}
