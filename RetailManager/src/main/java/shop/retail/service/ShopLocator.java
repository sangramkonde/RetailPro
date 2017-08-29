package shop.retail.service;

import java.util.List;

import shop.retail.models.Shop;


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
