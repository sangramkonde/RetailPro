package shop.retail.exception;


/**
 * This is our custom exception class created to handle the exception occurred
 * in retail manger application
 * 
 * @author Sangram
 *
 */
public class RetailManagerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public RetailManagerException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public RetailManagerException() {
		super();
	}
}
