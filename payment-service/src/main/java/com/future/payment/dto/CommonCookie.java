package com.future.payment.dto;

public class CommonCookie {
    private String idCredential;
    private String idCredentialCheck;
    private Integer expires;
    private String deviceId;
    private String deviceLocation;
    private String deviceOwner;
    private String deviceType;
    private String billingAgreementId;
    private String approvalCode;
    private String clientMatcherId;
    private String authGTN;

    /**
     * @return the idCredential
     */
    public String getIdCredential() {
        return idCredential;
    }

    /**
     * @param idCredential the idCredential to set
     */
    public void setIdCredential(final String idCredential) {
        this.idCredential = idCredential;
    }

    /**
     * @return the idCredentialCheck
     */
    public String getIdCredentialCheck() {
        return idCredentialCheck;
    }

    /**
     * @param idCredentialCheck the idCredentialCheck to set
     */
    public void setIdCredentialCheck(final String idCredentialCheck) {
        this.idCredentialCheck = idCredentialCheck;
    }

    /**
     * @return the expires
     */
    public Integer getExpires() {
        return expires;
    }

    /**
     * @param expires the expires to set
     */
    public void setExpires(final Integer expires) {
        this.expires = expires;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(final String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(final String deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(final String deviceType) {
        this.deviceType = deviceType;
    }

	/**
	 * @return the billingAgreementId
	 */
	public String getBillingAgreementId() {
		return billingAgreementId;
	}

	/**
	 * @param billingAgreementId the billingAgreementId to set
	 */
	public void setBillingAgreementId(String billingAgreementId) {
		this.billingAgreementId = billingAgreementId;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	/**
	 * @return the clientMatcherId
	 */
	public String getClientMatcherId() {
		return clientMatcherId;
	}

	/**
	 * @param clientMatcherId the clientMatcherId to set
	 */
	public void setClientMatcherId(String clientMatcherId) {
		this.clientMatcherId = clientMatcherId;
	}

	/**
	 * @return the authInvoiceId
	 */
	public String getAuthGTN() {
		return authGTN;
	}

	/**
	 * @param authInvoiceId the authInvoiceId to set
	 */
	public void setAuthGTN(String authInvoiceId) {
		this.authGTN = authInvoiceId;
	}

	
}
