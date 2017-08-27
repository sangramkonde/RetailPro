package shop.retail.dao;

import java.util.List;

import shop.retail.models.Shop;
import com.google.maps.model.LatLng;

/**
 * @author Sangram
 *
 */
public interface RetailShopDao {
	public Shop addShop(Shop shop);
	public Shop getShopById(long id);
	public Shop shopExists(String shopName);
	public Shop updateShop(Shop shop);
	public void deleteShop(long shopId);
	public Shop findNearest(String longitude, String latitude);
	public List<Shop> getAll();
}
