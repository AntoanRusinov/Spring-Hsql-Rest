package enums;

/**
 * @author antoan
 */
public enum CustomErrorStatus {
	
	ERROR, OK;
	
	private String message;

	private int statusCode;

	private int httpCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
	
}
