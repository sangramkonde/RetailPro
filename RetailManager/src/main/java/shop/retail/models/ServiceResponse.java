package shop.retail.models;

/**
 * This is a class where we returns 'success' as status
 * @author Sangram
 *
 */
public class ServiceResponse {

	private Boolean success;
	private String shop_status;

	/**
	 * Gets the 'success' as a status of this service.
	 * @return 'success'.
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * Initializes status = 'success' for the given service.
	 */
	public ServiceResponse(Boolean success) {
		this.success = success;
	}
	
	/**
	 * Initializes status = 'New shop added' for the given service.
	 * @param shop_status 
	 * @param success
	 */
	public ServiceResponse(Boolean success,String shop_status) {
		this.success = success;
		this.shop_status = shop_status;
	}

	/**
	 * Sets the status of this service.
	 * @param success
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getShopStatus() {
		return shop_status;
	}

	public void setShopStatus(String shop_status) {
		this.shop_status = shop_status;
	}
}
