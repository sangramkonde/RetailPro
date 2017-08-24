package shop.retail.service;

import shop.retail.BaseTest;
import shop.retail.Config;
import shop.retail.exception.RetailManagerException;
import shop.retail.models.Shop;
import shop.retail.service.ShopLocatorImpl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Sangram
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class ShopLocatorTests extends BaseTest{

	/*LatLng locationToTest = null;

    @Before
    public void setData() throws Exception {
         locationToTest = setLocationFromGoogleApi("Pune - Bengaluru Hwy, Pune".concat(",").concat(411014 + ""));
    }

    @Test
    public void testGeoApiResolver() {
        String address = "Pune - Bengaluru Hwy, Pune".concat(",").concat(411014 + "");
        LatLng location = ShopLocatorImpl.geoApiResolver(address);
        assert (isSameLocation(location,locationToTest));
    }

    @Test
    public void testSave() {
        Shop shop = buildShopObject("DMART Shop", "Pune - Bengaluru Hwy, Pune",
                411009,locationToTest.lat,locationToTest.lng);

        shopLocator.save(shop);
        assert (shopLocator.getAll().get(0).equals(shop));
    }

    @Test
    public void testNearest() {
        Shop Mumbai = buildShopObject("Shop  at Mumbai", "Number 1", 400307, 73.9823, 18.5793);
        Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796, 18.5529);
        Shop Nashik = buildShopObject("Shop at Nashik", "Number 3", 83, 73.7997, 18.6298);
        Shop Delhi = buildShopObject("Shop at Delhi", "Number 4", 545678, 88.3639, 22.5726);
        Shop Agra = buildShopObject("Shop at Agra", "Number 5", 1, 77.4126, 23.2599);
        Shop Chennai = buildShopObject("Shop at Chennai", "Number 6", 7, 72.8777, 19.076);
        shopInMemoryArray.add(Mumbai);
        shopInMemoryArray.add(Pune);
        shopInMemoryArray.add(Nashik);
        shopInMemoryArray.add(Delhi);
        shopInMemoryArray.add(Agra);
        shopInMemoryArray.add(Chennai);

        //Latitude and Longitude of m Pimpari is 73.9143	18.5679
        //Nearest shop from Pimpari should be at Pune
        assert shopLocator.findNearest(new LatLng(73.9143,18.5679)).equals(Pune);
        //Latitude and Longitude of Thane is 75.3433	19.8762
        //Nearest shop from Thane should be at Mumbai
        assert shopLocator.findNearest(new LatLng(75.3433,19.8762)).equals(Mumbai);
        //Latitude and Longitude of Ramapuram is 72.8777	19.076
        //Nearest shop from Ramapuram should be at Chennai itself
        assert shopLocator.findNearest(new LatLng(72.8777,19.076)).equals(Chennai);
    }

    private Shop buildShopObject(String name, String number, int post, Double latitude, Double longitude) {
        Shop shop = new Shop();
        shop.setShopName(name);
        shop.setShopAddress(new Shop.ShopAddress(number, post));
        shop.setShopLatitude(latitude);
        shop.setShopLongitude(longitude);
        return shop;
    }

    private LatLng setLocationFromGoogleApi(String address) throws Exception {
        GeoApiContext context = new GeoApiContext().setApiKey(Config.GEO_API_KEY);
        GeocodingResult result = GeocodingApi.geocode(context, address).await()[0];
        LatLng location = result.geometry.location;
        return location;
    }

    private boolean isSameLocation(LatLng l1, LatLng l2){
        if(l1==null || l2==null){
            return false;
        }
        if(l1.lat==l2.lat && l1.lng==l2.lng){
            return true;
        }
        else{
            return false;
        }
    }*/
}
