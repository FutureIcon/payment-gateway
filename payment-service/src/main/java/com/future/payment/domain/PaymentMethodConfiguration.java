package com.future.payment.domain;

import java.math.BigDecimal;

public class PaymentMethodConfiguration implements java.io.Serializable {

	/** The Constant YES_NO. */
	private static final String YES_NO = "yes_no";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -550448012153565664L;

	/*private PaymentMethodConfigurationId paymentMethodConfigurationId;

	private Set<PaymentSubAccountConfiguration> paymentSubAccountConfigurationSet;*/

	private String pmId;

	private String pluginName;

	private String tenantName;

	private String endPointName;

	private String country;

	private String currency;

	private Boolean canRefund;

	//private ReverseCheck reverseCheck;

	private String reBillable;

	private String rePudiable;

	//private IDCheck identityCheck;

	private BigDecimal minCharge;

	private BigDecimal maxCharge;

	private String costMethod;

	private String createPiHash;

	private Boolean canPartialPay; // new field

	private Boolean canMultiCharge; // new field

	private String canGetBalance; // new field

	private BigDecimal maxOverCharge;

	private Integer maxInstallments;

	private BigDecimal maxOverRefund; // will be mapped to canOverRefund based
										// on %age value

	private String shipBeforeCharge; // new field

	private Boolean canPartialCharge;

	private Boolean externalUi; // new field

	private Integer expires;

	private String threeDSProvider;

	private String paymentModel;

	private Boolean canPartialNotify; // new field

	private Boolean splitPaymentSupport;

	private String codePrefix;

	public Boolean getCanPartialNotify() {
		return canPartialNotify;
	}

	public void setCanPartialNotify(final Boolean canPartialNotify) {
		this.canPartialNotify = canPartialNotify;
	}

	/**
	 * Gets the pm id.
	 * 
	 * @return the pm id
	 */
	public String getPmId() {
		return pmId;
	}

	/**
	 * Sets the pm id.
	 * 
	 * @param pmId
	 *            the new pm id
	 */
	public void setPmId(final String pmId) {
		this.pmId = pmId;
	}

	/**
	 * Gets the plugin name.
	 * 
	 * @return the plugin name
	 */
	public String getPluginName() {
		return pluginName;
	}

	/**
	 * Sets the plugin name.
	 * 
	 * @param pluginName
	 *            the new plugin name
	 */
	public void setPluginName(final String pluginName) {
		this.pluginName = pluginName;
	}

	/**
	 * Gets the tenant name.
	 * 
	 * @return the tenant name
	 */
	public String getTenantName() {
		return tenantName;
	}

	/**
	 * Sets the tenant name.
	 * 
	 * @param tenantName
	 *            the new tenant name
	 */
	public void setTenantName(final String tenantName) {
		this.tenantName = tenantName;
	}

	/**
	 * Gets the end point name.
	 * 
	 * @return the end point name
	 */
	public String getEndPointName() {
		return endPointName;
	}

	/**
	 * Sets the end point name.
	 * 
	 * @param endPointName
	 *            the new end point name
	 */
	public void setEndPointName(final String endPointName) {
		this.endPointName = endPointName;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * Gets the currency.
	 * 
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 * 
	 * @param currency
	 *            the new currency
	 */
	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the can refund.
	 * 
	 * @return the can refund
	 */
	public Boolean getCanRefund() {
		return canRefund;
	}

	/**
	 * Sets the can refund.
	 * 
	 * @param canRefund
	 *            the new can refund
	 */
	public void setCanRefund(final Boolean canRefund) {
		this.canRefund = canRefund;
	}
	
	/**
	 * Gets the re billable.
	 * 
	 * @return the re billable
	 */
	public String getReBillable() {
		return reBillable;
	}

	/**
	 * Sets the re billable.
	 * 
	 * @param reBillable
	 *            the new re billable
	 */
	public void setReBillable(final String reBillable) {
		this.reBillable = reBillable;
	}

	/**
	 * Gets the re pudiable.
	 * 
	 * @return the re pudiable
	 */
	public String getRePudiable() {
		return rePudiable;
	}

	/**
	 * Sets the re pudiable.
	 * 
	 * @param rePudiable
	 *            the new re pudiable
	 */
	public void setRePudiable(final String rePudiable) {
		this.rePudiable = rePudiable;
	}

	/**
	 * Gets the min charge.
	 * 
	 * @return the min charge
	 */
	public BigDecimal getMinCharge() {
		return minCharge;
	}

	/**
	 * Sets the min charge.
	 * 
	 * @param minCharge
	 *            the new min charge
	 */
	public void setMinCharge(final BigDecimal minCharge) {
		this.minCharge = minCharge;
	}

	/**
	 * Gets the max charge.
	 * 
	 * @return the max charge
	 */
	public BigDecimal getMaxCharge() {
		return maxCharge;
	}

	/**
	 * Sets the max charge.
	 * 
	 * @param maxCharge
	 *            the new max charge
	 */
	public void setMaxCharge(final BigDecimal maxCharge) {
		this.maxCharge = maxCharge;
	}

	/**
	 * Gets the cost method.
	 * 
	 * @return the cost method
	 */
	public String getCostMethod() {
		return costMethod;
	}

	/**
	 * Sets the cost method.
	 * 
	 * @param costMethod
	 *            the new cost method
	 */
	public void setCostMethod(final String costMethod) {
		this.costMethod = costMethod;
	}

	/**
	 * Gets the can partial charge.
	 * 
	 * @return the can partial charge
	 */
	public Boolean getCanPartialCharge() {
		return canPartialCharge;
	}

	/**
	 * Sets the can partial charge.
	 * 
	 * @param canPartialCharge
	 *            the new can partial charge
	 */
	public void setCanPartialCharge(final Boolean canPartialCharge) {
		this.canPartialCharge = canPartialCharge;
	}

	/**
	 * Gets the max over charge.
	 * 
	 * @return the max over charge
	 */
	public BigDecimal getMaxOverCharge() {
		return maxOverCharge;
	}

	/**
	 * Sets the max over charge.
	 * 
	 * @param maxOverCharge
	 *            the new max over charge
	 */
	public void setMaxOverCharge(final BigDecimal maxOverCharge) {
		this.maxOverCharge = maxOverCharge;
	}

	/**
	 * Gets the max installments.
	 * 
	 * @return the max installments
	 */
	public Integer getMaxInstallments() {
		return maxInstallments;
	}

	/**
	 * Sets the max installments.
	 * 
	 * @param maxInstallments
	 *            the new max installments
	 */
	public void setMaxInstallments(final Integer maxInstallments) {
		this.maxInstallments = maxInstallments;
	}

	/**
	 * Gets the max over refund.
	 * 
	 * @return the max over refund
	 */
	public BigDecimal getMaxOverRefund() {
		return maxOverRefund;
	}

	/**
	 * Sets the max over refund.
	 * 
	 * @param maxOverRefund
	 *            the new max over refund
	 */
	public void setMaxOverRefund(final BigDecimal maxOverRefund) {
		this.maxOverRefund = maxOverRefund;
	}

	/**
	 * Gets the ship before charge.
	 * 
	 * @return the ship before charge
	 */
	public String getShipBeforeCharge() {
		return shipBeforeCharge;
	}

	/**
	 * Sets the ship before charge.
	 * 
	 * @param shipBeforeCharge
	 *            the new ship before charge
	 */
	public void setShipBeforeCharge(final String shipBeforeCharge) {
		this.shipBeforeCharge = shipBeforeCharge;
	}

	/**
	 * Gets the can get balance.
	 * 
	 * @return the can get balance
	 */
	public String getCanGetBalance() {
		return canGetBalance;
	}

	/**
	 * Sets the can get balance.
	 * 
	 * @param canGetBalance
	 *            the new can get balance
	 */
	public void setCanGetBalance(final String canGetBalance) {
		this.canGetBalance = canGetBalance;
	}

	/**
	 * Gets the can partial pay.
	 * 
	 * @return the can partial pay
	 */
	public Boolean getCanPartialPay() {
		return canPartialPay;
	}

	/**
	 * Sets the can partial pay.
	 * 
	 * @param canPartialPay
	 *            the new can partial pay
	 */
	public void setCanPartialPay(final Boolean canPartialPay) {
		this.canPartialPay = canPartialPay;
	}

	/**
	 * Gets the can multi charge.
	 * 
	 * @return the can multi charge
	 */
	public Boolean getCanMultiCharge() {
		return canMultiCharge;
	}

	/**
	 * Sets the can multi charge.
	 * 
	 * @param canMultiCharge
	 *            the new can multi charge
	 */
	public void setCanMultiCharge(final Boolean canMultiCharge) {
		this.canMultiCharge = canMultiCharge;
	}

	/**
	 * Gets the external ui.
	 * 
	 * @return the external ui
	 */
	public Boolean getExternalUi() {
		return externalUi;
	}

	/**
	 * Sets the external ui.
	 * 
	 * @param externalUi
	 *            the new external ui
	 */
	public void setExternalUi(final Boolean externalUi) {
		this.externalUi = externalUi;
	}

	/**
	 * Gets the expires.
	 * 
	 * @return the expires
	 */
	public Integer getExpires() {
		return expires;
	}

	/**
	 * Sets the expires.
	 * 
	 * @param expires
	 *            the new expires
	 */
	public void setExpires(final Integer expires) {
		this.expires = expires;
	}

	/**
	 * Gets the three ds provider.
	 * 
	 * @return the three ds provider
	 */
	public String getThreeDSProvider() {
		return threeDSProvider;
	}

	/**
	 * Sets the three ds provider.
	 * 
	 * @param threeDSProvider
	 *            the new three ds provider
	 */
	public void setThreeDSProvider(final String threeDSProvider) {
		this.threeDSProvider = threeDSProvider;
	}

	/**
	 * Gets the payment model.
	 * 
	 * @return the payment model
	 */
	public String getPaymentModel() {
		return paymentModel;
	}

	/**
	 * Sets the payment model.
	 * 
	 * @param paymentModel
	 *            the new payment model
	 */
	public void setPaymentModel(final String paymentModel) {
		this.paymentModel = paymentModel;
	}

	/**
	 * Gets the creates the pi hash.
	 * 
	 * @return the createPiHash
	 */
	public String getCreatePiHash() {
		return createPiHash;
	}

	/**
	 * Sets the creates the pi hash.
	 * 
	 * @param createPiHash
	 *            the createPiHash to set
	 */
	public void setCreatePiHash(final String createPiHash) {
		this.createPiHash = createPiHash;
	}

	public Boolean getSplitPaymentSupport() {
		return splitPaymentSupport;
	}

	public void setSplitPaymentSupport(Boolean splitPaymentSupport) {
		this.splitPaymentSupport = splitPaymentSupport;
	}

	public String getCodePrefix() {
		return codePrefix;
	}

	public void setCodePrefix(String codePrefix) {
		this.codePrefix = codePrefix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PaymentMethodConfiguration)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 0;
	}
}
