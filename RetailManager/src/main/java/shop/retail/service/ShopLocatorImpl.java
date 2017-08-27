package shop.retail.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import shop.retail.Config;
import shop.retail.RetailMessages;
import shop.retail.dao.RetailShopDao;
import shop.retail.exception.RetailManagerException;
import shop.retail.models.Shop;
import shop.retail.models.ShopAddress;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

/**
 * 
 * @author Sangram
 * 
 */
@Service
public class ShopLocatorImpl implements ShopLocator {
	private static final Logger logger = LoggerFactory
			.getLogger(ShopLocatorImpl.class);

	@Autowired
	private RetailShopDao retailShopDao;

	@Override
	public Shop getShopById(long id) {
		return retailShopDao.getShopById(id);
	}

	@Override
	public Shop addShop(Shop shop) {
		validate(shop);
		Shop oldShop = retailShopDao.shopExists(shop.getShopName());
		// Query string for the Geo API
		ShopAddress shop_address = shop.getShopAddress();
		StringBuilder address = new StringBuilder(shop_address.getNumber())
				.append(",").append(shop_address.getPostCode());
		// Get the latitude & longitude
		LatLng location = geoApiResolver(address.toString());
		shop_address.setShopLatitude(location.lat);
		shop_address.setShopLongitude(location.lng);
		Shop newShop = null;
		if (null != oldShop) {
			shop.setShopId(oldShop.getShopId());
			newShop=retailShopDao.updateShop(shop);
			newShop.setOldShopAddress(oldShop.getShopAddress());
		} else {
			newShop = retailShopDao.addShop(shop);
		}
		return newShop;
	}

	@Override
	public Shop findNearest(String longitude, String latitude) throws RetailManagerException {

		try {
			LatLng location = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

			List<Shop> shops = getAll();
			if (shops == null || shops.isEmpty()) {
				logger.info(RetailMessages.NO_SHOPS_ADDED);
				throw new RetailManagerException(RetailMessages.NO_SHOPS_ADDED);
			}

			double nearest = Double.MAX_VALUE;
			double temp = 0;
			Shop nearest_shop = shops.get(0);
			for (Shop shop : shops) {
				temp = calculateDistance(location, new LatLng(shop
						.getShopAddress().getShopLatitude(), shop
						.getShopAddress().getShopLongitude()));
				if (temp < nearest) {
					nearest = temp;
					nearest_shop = shop;
				}
			}
			if (nearest == 0.0) {
				logger.info("Found shop with an exact location match.");
			}
			return nearest_shop;
		} catch (NumberFormatException e) {
			logger.error(RetailMessages.INVALID_LOCATION + " - " + longitude+ ", " + latitude, e);
			throw new RetailManagerException(RetailMessages.INVALID_LOCATION);
		} catch (RetailManagerException rmse) {
			throw rmse;
		} catch (Exception e) {
			logger.error(RetailMessages.ERROR_SHOP + latitude + ", "+ longitude, e);
			throw new RetailManagerException(RetailMessages.SERVICE_UNAVAILABLE);
		}
	}

	@Override
	public List<Shop> getAll() {
		return retailShopDao.getAll();
	}

	public static LatLng geoApiResolver(String address_in_one_line)
			throws RetailManagerException {
		Config.loadProperties();
		GeoApiContext context = new GeoApiContext()
				.setApiKey(Config.GEO_API_KEY);
		try {
			GeocodingResult result = GeocodingApi.geocode(context,
					address_in_one_line).await()[0];
			LatLng location = result.geometry.location;
			return location;
		} catch (Exception e) {
			logger.error("Error while fetching data from google geo api.", e);
			throw new RetailManagerException(RetailMessages.GEO_LOCATION_ERROR);
		}
	}

	private Double calculateDistance(LatLng l1, LatLng l2)
			throws RetailManagerException {
		double theta = l1.lng - l2.lng;
		double distance = Math.sin(deg2rad(l1.lat)) * Math.sin(deg2rad(l2.lat))
				+ Math.cos(deg2rad(l1.lat)) * Math.cos(deg2rad(l2.lat))
				* Math.cos(deg2rad(theta));
		distance = Math.acos(distance);
		distance = rad2deg(distance);
		return distance * 60 * 1.1515;
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	private void validate(Shop shop) {
		if (shop == null || shop.getShopAddress() == null
				|| shop.getShopAddress().getNumber() == null
				|| shop.getShopAddress().getPostCode() == 0) {
			logger.debug("Invalid shop - " + shop);
			throw new RetailManagerException(RetailMessages.INVALID_SHOP);
		}
	}

	@Override
	public void deleteShop(long shopId) {
		retailShopDao.deleteShop(shopId);
	}

}
