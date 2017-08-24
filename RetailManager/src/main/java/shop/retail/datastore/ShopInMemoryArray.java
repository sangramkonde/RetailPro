package shop.retail.datastore;

import shop.retail.models.Shop;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class used to store the shop details in-memory array.
 * 
 * @author Sangram
 *
 */
public class ShopInMemoryArray {

	@NotNull
	private List<Shop> shops = Collections.synchronizedList(new ArrayList<Shop>());

	/**
	 * Retrieving a shop on the basis of index from synchronized list.
	 * 
	 * @return shops
	 *
	 */
	public Shop get(int index) {
		return shops.get(index);
	}

	/**
	 * Adding the shop into synchronized list.
	 * 
	 * @param Shop
	 *
	 */
	public void add(Shop Shop) {
		shops.add(Shop);
	}

	/**
	 * Removing the shop from synchronized list.
	 * 
	 * @param Shop
	 *
	 */
	public void remove(Shop Shop) {
		shops.remove(Shop);
	}

	/**
	 * Removing the shop on the basis of index from synchronized list.
	 * 
	 * @param Shop
	 *
	 */
	public void remove(int index) {
		shops.remove(index);
	}

	/**
	 * Retrieving details of all shop from synchronized list.
	 * 
	 * @return shops
	 *
	 */
	public List<Shop> getAll() {
		return Collections.unmodifiableList(shops);
	}
}
