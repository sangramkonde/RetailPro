package shop.retail.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shop_address")
public class ShopAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String number;
	private int postCode;

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
	
	@Override
	public String toString() {
		return "ShopAddress [id=" + id + ", number=" + number + ", postCode="
				+ postCode + "]";
	}

}
