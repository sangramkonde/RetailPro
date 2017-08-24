package shop.retail.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shop_address")
public class ShopAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long id;
	private String number;
	private int postCode;
	@Column(name="latitude")
	private Double shopLatitude;
	@Column(name="longitude")
	private Double shopLongitude;
	
	public ShopAddress() {
		// default no-argument constructor
	}

	public ShopAddress(String number, int postCode) {
		//this.number = number;
		this.postCode = postCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	
	public Double getShopLatitude() {
		return shopLatitude;
	}

	public void setShopLatitude(Double shopLatitude) {
		this.shopLatitude = shopLatitude;
	}

	public Double getShopLongitude() {
		return shopLongitude;
	}

	public void setShopLongitude(Double shopLongitude) {
		this.shopLongitude = shopLongitude;
	}

	@Override
	public String toString() {
		return "ShopAddress [id=" + id + ", number=" + number + ", postCode="
				+ postCode + ", shopLatitude=" + shopLatitude
				+ ", shopLongitude=" + shopLongitude + "]";
	}

}
