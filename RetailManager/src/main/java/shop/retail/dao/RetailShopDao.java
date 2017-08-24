package shop.retail.dao;

import java.util.List;

import shop.retail.models.Shop;
import com.google.maps.model.LatLng;

public interface RetailShopDao {
	public void addShop(Shop shop);
	public Shop getShopById(long id);
	public Shop shopExists(String shopName);
	public Shop updateShop(Shop shop);
	public Shop findNearest(LatLng location);
	public List<Shop> getAll();
}
