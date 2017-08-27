package shop.retail.models;

import com.google.maps.model.LatLng;

import shop.retail.BaseTest;
import shop.retail.service.ShopLocator;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sangram
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class ModelTest extends BaseTest{

	/*@Autowired
	private ShopLocator shopLocator;
	
	@Test
    public void testShop() throws JsonProcessingException, JSONException {
        Shop shop = new Shop();
        ShopAddress shopAddress = new ShopAddress();
        shop.setShopName("DMART Shop");
        shopAddress.setNumber("222891");
		shopAddress.setPostCode(411009);
		shopAddress.setShopLatitude(18.5793);
		shopAddress.setShopLongitude(73.9823);
        shop.setShopAddress(shopAddress);
//        shop.setShopLongitude(18.5793);
//        shop.setShopLatitude(73.9823);

        String expected = "{\"shopName\":\"DMART Shop\",\"shopAddress\":{\"number\":\"222891\"," +
                "\"postCode\":411009},\"shopLatitude\":73.9823,\"shopLongitude\":18.5793}";
        String actual = objectMapper.writeValueAsString(shop);
        //JSONObject actuaObject = new JSONObject(actual);
        JSONAssert.assertEquals(expected, actual, false);

        Shop shop2 = new Shop();
        shop2.setShopName("DMART Shop");
        shop2.setShopAddress(new Shop.ShopAddress("222891", 411009));
        shop2.setShopLongitude(18.5793);
        shop2.setShopLatitude(73.9823);
        
        Shop shop2 = new Shop();
        ShopAddress shopAddress2 = new ShopAddress();
        shop2.setShopName("DMART Shop");
        shopAddress2.setNumber("222891");
		shopAddress2.setPostCode(411009);
		shopAddress2.setShopLatitude(18.5793);
		shopAddress2.setShopLongitude(73.9823);
        shop2.setShopAddress(shopAddress2);
        
        boolean test = shop.equals(shop2);

        assert(shop.equals(shop2));

        shop2.setShopName("dmart shop");
        assert(!shop.equals(shop2));
    }

    @Test
    public void testShopInMemoryArray() {
//        ShopInMemoryArray shopInMemoryArray = new ShopInMemoryArray();
        Shop shop = new Shop();
        ShopAddress shopAddress = new ShopAddress();
        shop.setShopName("DMART Shop");
        shop.setShopId(1);
        shopAddress.setNumber("222891");
		shopAddress.setPostCode(411009);
		shopAddress.setShopLatitude(18.5793);
		shopAddress.setShopLongitude(73.9823);
        shop.setShopAddress(shopAddress);
        shopLocator.addShop(shop);
        Assert.assertTrue(shop.equals(shopLocator.getShopById(1)));
        Shop shop2 = new Shop();
        ShopAddress shopAddress2 = new ShopAddress();
        shop2.setShopName("DMART Shop");
        shop2.setShopId(2);
        shopAddress2.setNumber("222891");
		shopAddress2.setPostCode(411009);
		shopAddress2.setShopLatitude(18.5793);
		shopAddress2.setShopLongitude(73.9823);
        shop2.setShopAddress(shopAddress2);
        shopLocator.addShop(shop);

        Assert.assertTrue(shopLocator.getAll().size() == 2);

        shopLocator.deleteShop(shop.getShopId());
        Assert.assertTrue(shopLocator.getAll().size() == 1);
        Assert.assertTrue(shop2.equals(shopLocator.getShopById(shop2.getShopId())));

        shopLocator.deleteShop(shop.getShopId());
        Assert.assertTrue(shopLocator.getAll().size() == 0);
    }*/

}
