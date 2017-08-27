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

	/*@NotNull
	private HttpStatus httpStatusCode;

	*//**
	 * Use to initialize the exception by setting message and status code
	 * 
	 * @param message
	 * @param httpStatusCode
	 *//*
	public RetailManagerException(Exception e, String message,
			HttpStatus httpStatusCode) {
		super(message, e);
		this.httpStatusCode = httpStatusCode;
	}

	*//**
	 * Use to initialize the exception by setting message and status code
	 * 
	 * @param message
	 * @param httpStatusCode
	 *//*
	public RetailManagerException(String message, HttpStatus httpStatusCode) {
		super(message);
		this.httpStatusCode = httpStatusCode;
	}

	*//**
	 * Use to get the http status code on the basis of operation
	 * 
	 * @return httpStatusCode
	 *//*
	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}*/
}
