package shop.retail.models;

import com.google.maps.model.LatLng;
import shop.retail.BaseTest;
import shop.retail.datastore.ShopInMemoryArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sangram
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class ModelTest extends BaseTest{

	/*@Test
    public void testShop() throws JsonProcessingException {
        Shop shop = new Shop();
        shop.setShopName("DMART Shop");
        shop.setShopAddress(new Shop.ShopAddress("222891", 411009));
        shop.setShopLongitude(18.5793);
        shop.setShopLatitude(73.9823);

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
        boolean test = shop.equals(shop2);

        assert(shop.equals(shop2));

        shop2.setShopName("dmart shop");
        assert(!shop.equals(shop2));
    }

    @Test
    public void testShopInMemoryArray() {
        ShopInMemoryArray shopInMemoryArray = new ShopInMemoryArray();
        Shop shop = new Shop();
        shop.setShopName("DMART Shop");
        shop.setShopAddress(new Shop.ShopAddress("222891", 411009));
        shop.setShopLongitude(18.5793);
        shop.setShopLatitude(73.9823);
        shopInMemoryArray.add(shop);
        Assert.assertTrue(shop.equals(shopInMemoryArray.get(0)));
        Shop shop2 = new Shop();
        shop2.setShopName("DMART Shop");
        shop2.setShopAddress(new Shop.ShopAddress("222891", 411009));
        shop2.setShopLongitude(18.5793);
        shop2.setShopLatitude(73.9823);
        shopInMemoryArray.add(shop2);

        Assert.assertTrue(shopInMemoryArray.getAll().size() == 2);

        shopInMemoryArray.remove(shop);
        Assert.assertTrue(shopInMemoryArray.getAll().size() == 1);
        Assert.assertTrue(shop2.equals(shopInMemoryArray.get(0)));

        shopInMemoryArray.remove(0);
        Assert.assertTrue(shopInMemoryArray.getAll().size() == 0);
    }*/

}
