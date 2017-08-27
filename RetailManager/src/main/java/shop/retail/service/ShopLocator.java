package shop.retail.service;

import com.google.maps.model.LatLng;
import shop.retail.models.Shop;
import java.util.List;


/**
 * This is a interface that has following methods
 * @author Sangram
 *
 */
public interface ShopLocator {

	public Shop addShop(Shop shop);
	public Shop getShopById(long shopId);
	public void deleteShop(long shopId);
	public Shop findNearest(String longitude, String latitude);
	public List<Shop> getAll();
}
