package shop.retail.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shop.retail.dao.RetailShopDao;
import shop.retail.models.Shop;
import shop.retail.models.ShopAddress;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 * @author Sangram
 *
 */

@ContextConfiguration(classes = {ShopLocatorTestConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {
	    "GEO_API_KEY=AIzaSyA0I0_VRGOuh-CFMjWBQGI2ZX7rfluxMtA",
})
public class ShopLocatorTests {
	
	@Autowired
	private RetailShopDao retailShopDao;
	
	@Autowired
	private ShopLocator shopLocator;
	
	LatLng locationToTest = null;
	
	@Value("${GEO_API_KEY}")
	String geoApiKey;
	
	@Test
	public void testValueSetup() {
	    assertEquals("AIzaSyA0I0_VRGOuh-CFMjWBQGI2ZX7rfluxMtA", geoApiKey);
	}
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Before
	public void setData() throws Exception {
		locationToTest = setLocationFromGoogleApi("Pune - Bengaluru Hwy, Pune"
				.concat(",").concat(411014 + ""));
	}
	
	private Shop buildShopObject(String name, String number, int post,
		Double latitude, Double longitude) {
		Shop shop = new Shop();
		ShopAddress shopAddress = new ShopAddress();
		shop.setShopName(name);
		shopAddress.setNumber(number);
		shopAddress.setPostCode(post);
		shopAddress.setShopLatitude(latitude);
		shopAddress.setShopLongitude(longitude);
		shop.setShopAddress(shopAddress);
		return shop;
	}
	
	@Test
	public void testGetAllShop(){
		List<Shop> shopList = new ArrayList<Shop>();
		
		Shop Mumbai = buildShopObject("Shop  at Mumbai", "Number 1", 400307,
				73.9823, 18.5793);
		Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796,
				18.5529);
		Shop Nashik = buildShopObject("Shop at Nashik", "Number 3", 83,
				73.7997, 18.6298);
		Shop Delhi = buildShopObject("Shop at Delhi", "Number 4", 545678,
				88.3639, 22.5726);
		Shop Agra = buildShopObject("Shop at Agra", "Number 5", 1, 77.4126,
				23.2599);
		Shop Chennai = buildShopObject("Shop at Chennai", "Number 6", 7,
				72.8777, 19.076);
		
		shopList.add(Mumbai);
		shopList.add(Pune);
		shopList.add(Nashik);
		shopList.add(Delhi);
		shopList.add(Agra);
		shopList.add(Chennai);
		when(retailShopDao.getAll()).thenReturn(shopList);
		
		List<Shop> result = shopLocator.getAll();
		assertEquals(6, result.size());
	}
	
	@Test
	public void testGetShopById(){
		Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796,
				18.5529);
		Pune.setShopId(1L);
		when(retailShopDao.getShopById(Pune.getShopId())).thenReturn(Pune);
		Shop result = shopLocator.getShopById(Pune.getShopId());
		assertEquals(1L, result.getShopId());
		assertEquals("Shop at Pune", result.getShopName());
	}
	
	@Test
	public void testNearest() {
		List<Shop> shopList = new ArrayList<Shop>();
		Shop Mumbai = buildShopObject("Shop  at Mumbai", "Number 1", 400307,
				73.9823, 18.5793);
		Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796,
				18.5529);
		Shop Nashik = buildShopObject("Shop at Nashik", "Number 3", 83,
				73.7997, 18.6298);
		Shop Delhi = buildShopObject("Shop at Delhi", "Number 4", 545678,
				88.3639, 22.5726);
		Shop Agra = buildShopObject("Shop at Agra", "Number 5", 1, 77.4126,
				23.2599);
		Shop Chennai = buildShopObject("Shop at Chennai", "Number 6", 7,
				72.8777, 19.076);
		
		shopList.add(Mumbai);
		shopList.add(Pune);
		shopList.add(Nashik);
		shopList.add(Delhi);
		shopList.add(Agra);
		shopList.add(Chennai);
		
		when(shopLocator.getAll()).thenReturn(shopList);
		Shop shop =shopLocator.findNearest("22.5726", "88.3639");
		assertEquals(shop.getShopName(),Delhi.getShopName());
		
	}
	
	@Test
	public void addShop(){
		Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796,
				18.5529);
		when(retailShopDao.addShop(Pune)).thenReturn(Pune);
		Shop result = shopLocator.addShop(Pune);
//		assertEquals(8, result.getShopId());
		assertEquals("Shop at Pune", result.getShopName());
		assertEquals("Number 2", result.getShopAddress().getNumber());
	}
	
	
	@Test
	public void deleteShop(){
		Shop Pune = buildShopObject("Shop at Pune", "Number 2", 900, 73.8796,
				18.5529);
		shopLocator.deleteShop(Pune.getShopId());
        verify(retailShopDao, times(1)).deleteShop(Pune.getShopId());
	}
	
	@Test
	public void testGeoApiResolver() {
		String address = "Pune - Bengaluru Hwy, Pune".concat(",").concat(
				411014 + "");
		LatLng location = ShopLocatorImpl.geoApiResolver(address);
		assert (isSameLocation(location, locationToTest));
	}
	
	private LatLng setLocationFromGoogleApi(String address) throws Exception {
		GeoApiContext context = new GeoApiContext()
				.setApiKey(geoApiKey);
		GeocodingResult result = GeocodingApi.geocode(context, address).await()[0];
		LatLng location = result.geometry.location;
		return location;
	}
	
	private boolean isSameLocation(LatLng l1, LatLng l2) {
		if (l1 == null || l2 == null) {
			return false;
		}
		if (l1.lat == l2.lat && l1.lng == l2.lng) {
			return true;
		} else {
			return false;
		}
	}
}
