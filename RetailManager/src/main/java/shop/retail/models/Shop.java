package shop.retail.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * Represents a Shop located across the geographical region. A shop can be
 * registered on the basis on address, name, number and postcode .
 * 
 * @author Sangram
 * 
 */
@Entity
@Table(name="shop")
public class Shop {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="shop_id")
	private long shopId;
	
	@Column(name="shop_name" ,unique = true)
	private String shopName;
	@Column(name="latitude")
	private Double shopLatitude;
	@Column(name="longitude")
	private Double shopLongitude;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_address_id")
	private ShopAddress shopAddress;
	
	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	/**
	 * Gets the name of the shop
	 * 
	 * @return shopName.
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * Sets the name of the shop.
	 * 
	 * @param shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * Gets the address of the shop
	 * 
	 * @return shopAddress.
	 */
	public ShopAddress getShopAddress() {
		return shopAddress;
	}

	/**
	 * Sets the address of the shop.
	 * 
	 * @param shopAddress
	 */
	public void setShopAddress(ShopAddress shopAddress) {
		this.shopAddress = shopAddress;
	}

	/**
	 * Gets the latitude of the shop
	 * 
	 * @return shopLatitude.
	 */
	public Double getShopLatitude() {
		return shopLatitude;
	}

	/**
	 * Sets the latitude of the shop.
	 * 
	 * @param shopLatitude
	 */
	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

	/**
	 * Gets the longitude of the shop
	 * 
	 * @return shopLongitude.
	 */
	public Double getShopLongitude() {
		return shopLongitude;
	}

	/**
	 * Sets the longitude of the shop.
	 * 
	 * @param shopLongitude
	 */
	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName
				+ ", shopLatitude=" + shopLatitude + ", shopLongitude="
				+ shopLongitude + ", shopAddress=" + shopAddress + "]";
	}

}
