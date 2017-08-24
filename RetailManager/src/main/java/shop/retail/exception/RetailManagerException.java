package shop.retail.exception;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

/**
 * This is our custom exception class created to handle the exception occurred
 * in retail manger application
 * 
 * @author Sangram
 *
 */
@SuppressWarnings("serial")
public class RetailManagerException extends RuntimeException {

	@NotNull
	private HttpStatus httpStatusCode;

	/**
	 * Use to initialize the exception by setting message and status code
	 * 
	 * @param message
	 * @param httpStatusCode
	 */
	public RetailManagerException(Exception e, String message,
			HttpStatus httpStatusCode) {
		super(message, e);
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * Use to initialize the exception by setting message and status code
	 * 
	 * @param message
	 * @param httpStatusCode
	 */
	public RetailManagerException(String message, HttpStatus httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	/**
	 * Use to get the http status code on the basis of operation
	 * 
	 * @return httpStatusCode
	 */
	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}
}
