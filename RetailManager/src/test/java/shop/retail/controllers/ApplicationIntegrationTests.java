package shop.retail.controllers;

import shop.retail.BaseTest;
import shop.retail.RetailMessages;
import shop.retail.datastore.ShopInMemoryArray;
import shop.retail.models.Shop;
import shop.retail.service.ShopLocator;
import shop.retail.service.ShopLocatorImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sangram
 *
 */
public class ApplicationIntegrationTests extends BaseTest{

	/*@Before
	public void setUp() {
		ShopInMemoryArray shopInMemoryArray = new ShopInMemoryArray();
		ShopLocator shopLocatorService = new ShopLocatorImpl();
		shopLocatorService.setInMemoryArray(shopInMemoryArray);
		RetailShopController retailManagerController = new RetailShopController();
		retailManagerController.setShopLocator(shopLocatorService);
		retailManagerController.setObjectMapper(new ObjectMapper());
		RestAssuredMockMvc.standaloneSetup(retailManagerController);
	}

	@Test
	public void testApplicationStatus() {
		given().when().get("/shop/").then().statusCode(200);
	}

	@Test
	public void testAddShop() {
		// Bad request - Missing body
		given().when().post("/shop/add").then().statusCode(400);
		Shop shop = new Shop();
		shop.setShopName("My Shop");
		// Missing Address
		given().contentType("application/json").body(shop).when()
				.post("/shop/add").then().statusCode(400);

		// Address is needed in a request body
		shop.setShopAddress(new Shop.ShopAddress("Address", 222));
		given().contentType("application/json").body(shop).when()
				.post("/shop/add").then().statusCode(201);
	}

	@Test
	public void testResponseJson() {
		// Bad Request since request param is null
		given().when().get("/shop/find?customerLatitude=&customerLongitude")
				.then().statusCode(400);
		// Bad Request since request param's value is invalid
		given().when()
				.get("/shop/find?customerLatitude=testlatitude&customerLongitude=testlongitude")
				.then().statusCode(400);
		// No shops has been added yet
		given().when()
				.get("/shop/find?customerLatitude=90&customerLongitude=55")
				.then().statusCode(200).assertThat(result -> {result.toString().equals(RetailMessages.NO_SHOPS_ADDED);
				});
	}*/

}
