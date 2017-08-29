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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 
 * Represents a Shop located across the geographical region. A shop can be
 * registered on the basis on address, name, number and postcode .
 * 
 * @author Sangram
 * 
 */
@Entity
@Table(name = "shop")
public class Shop {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shop_id")
	private long shopId;

	@Column(name = "shop_name", unique = true)
	private String shopName;

	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_address_id")
	private ShopAddress shopAddress;

	@Transient
	@JsonInclude(value= JsonInclude.Include.NON_NULL)
	private ShopAddress oldShopAddress;
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

	public ShopAddress getOldShopAddress() {
		return oldShopAddress;
	}

	public void setOldShopAddress(ShopAddress oldShopAddress) {
		this.oldShopAddress = oldShopAddress;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName
				+ ", shopAddress=" + shopAddress + "]";
	}
}
