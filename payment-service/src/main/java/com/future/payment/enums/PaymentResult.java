package com.future.payment.enums;

public enum PaymentResult {

	 NO_MATCHING_PLUGIN_FOUND("S500", ""),
	 GATEWAY_CONFIGURATION_ERROR("{S501",""),
	 SERVICE_LOCKED("{S502",""),
	 GATEWAY_INTERNAL_ERROR("{S503",""),
	 GATEWAY_MERCHANT_SETUP_ERROR("{S504",""),
	 GATEWAY_DOWNSTREAM_UNKNOWN_ERROR("{S505",""),
	 ERROR_CONNECTION_FAILURE_TIMEOUT("{S506",""),
	 GATEWAY_DOWNSTREAM_CONNECT_TIMEOUT("{S507",""),
	 GATEWAY_INVALID_REQUEST_FORMAT("{S508",""),
	 GATEWAY_INVALID_DATA("{S509",""),
	 GATEWAY_UNKNOWN_ERROR("{S510",""),
	 MISSING_CLIENT_ID("{S550",""),
	 MISSING_CLIENT_REQUEST_ID("{S551",""),
	 MISSING_ORDER_NUMBER("{S552",""),
	 DUPLICATE_CLIENT_REQUEST("{S553",""),
	 MISSING_PAYMENT_HANDLE("{S554",""),
	 SERVICE_TEMPORARILY_BUSY("{S555",""),
	 PLC_DATABASE_ISSUE("{S556",""),
	 EMPTY_PAYLOAD("{S557",""),
	 INVALID_PIHASH("{S558",""),
	 PISHIELD_EXCEPTION("{S559",""),
	 PLUGIN_NOT_FOUND("{S560",""),
	 JAVA_EXCEPTION_IN_PLUGIN_OR_SERVICE("{S561",""),
	 PLUGIN_RESPONSE_EMPTY("{S562",""),
	 PAYMENT_HANDLE_BUSY("{S563",""),
	 INPUT_TOO_LONG_CANNOT_TRUNCATE("{S564",""),
	 INVALID_AMOUNT("{S565",""),
	 NONNUMERIC_VALUE_IN_NUMERIC_FIELD("{S566",""),
	 MISSING_OR_BAD_DATA("{S567",""),
	 INVALID_REDO_REQID("{S568",""),
	 SERVICE_UNSUPPORTED_PMID("{S569",""),
	 PLUGIN_UNSUPPORTED_PMID("{S570",""),
	 BAD_PAYGET_METHODS_CONFIG("{S571",""),
	 ILLEGAL_PAYMENT_STATE("{S574",""),
	 MISSING_OR_INVALID_EMAIL_ADDRESS("{S575",""),
	 MISSING_OR_INVALID_CURRENCY("{S581",""),
	 UNKNOWN_ERROR("{S999",""),
	 INTERNAL_SERVER_ERROR("S500","internal server error"),
	 NORMAL("S200","Everything goes well."),
	 VALID_ERROR("S201","Fail to pass the validation.");
		
	private String code;
	private String message;
	
	private PaymentResult (String code, String message) {
		this.code = code;
		this.message= message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}