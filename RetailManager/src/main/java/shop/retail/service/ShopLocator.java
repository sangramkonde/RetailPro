package shop.retail.service;

import com.google.maps.model.LatLng;
import shop.retail.datastore.ShopInMemoryArray;
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
	public Shop findNearest(LatLng location);
	public List<Shop> getAll();
}
