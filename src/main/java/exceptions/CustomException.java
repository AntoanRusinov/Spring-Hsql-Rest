package exceptions;

import enums.CustomErrorStatus;

/**
 * @author antoan
 */
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	private CustomErrorStatus customErrorStatus;

	public CustomException(String errorCode, String errorMessage, CustomErrorStatus customErrorStatus) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.customErrorStatus = customErrorStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public CustomErrorStatus getCustomErrorStatus() {
		return customErrorStatus;
	}

	public void setCustomErrorStatus(CustomErrorStatus customErrorStatus) {
		this.customErrorStatus = customErrorStatus;
	}

}