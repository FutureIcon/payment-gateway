package com.future.payment.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.future.payment.plugin.PaymentPlugin;

public class PaymentDTO {
	private String version;
	private String clientId;
	private String paymentHandle;
	private String status;
	private BigDecimal amountReserved;
	private BigDecimal amountCanceled;
	private BigDecimal amountRefunded;
	private BigDecimal amountCredited;
	private String pluginCookie;
	private String piHash;
	private String pmId;
	private String currency;
	private String country;
	private BigDecimal amountRequested;
	private BigDecimal amountPaid;
	// this will store the clientReqId which locked payment
	private String lockedClientReqId;
	private Date lockedDate;
	// private PaymentSubAccountConfiguration subAccountConfiguration;
	private String businessType;
	private ServiceCookie serviceCookie;
	// private PaymentMethodConfiguration pmConf;
	// private PaymentMethodConfiguration postPMConf;
	// private PaymentTenants tenant;
	private PaymentPlugin plugin;
	private String clientReqId;
	private String customerId;
	private String invoiceId;
	private String verticalId;
	private Date expiryDate;
	private Boolean isFinal;
	private int daysToExpire; // TODO: what's this for?
	private Date authExpiryDate;
	private String activeSplitPayment;
	private boolean isForceClearing;
	private boolean isSplitPaymentHandle;
	private String parentPaymentHandle;
	private Boolean hasChargeback;
	//private TenantPluginOperation tenantPluginOperation;
	private String piSource;
	private String piSourceReqId;

	/**
	 * @return the tenant
	 */
	/*public PaymentTenants getTenant() {
		return tenant;
	}

	*//**
	 * @param tenant
	 *            the tenant to set
	 *//*
	public void setTenant(PaymentTenants tenant) {
		this.tenant = tenant;
	}*/

	/** The max shippable. */
	private BigDecimal maxShippable;

	/** The max refundable. */
	private BigDecimal maxRefundable;

	/** The max cancelable. */
	private BigDecimal maxCancelable;

	private String testMode;

	/**
	 * @return the invoiceId
	 */
	public String getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId
	 *            the invoiceId to set
	 */
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return the verticalId
	 */
	public String getVerticalId() {
		return verticalId;
	}

	/**
	 * @param verticalId
	 *            the verticalId to set
	 */
	public void setVerticalId(String verticalId) {
		this.verticalId = verticalId;
	}

	/**
	 * @return the clientReqId
	 */
	public String getClientReqId() {
		return clientReqId;
	}

	/**
	 * @param clientReqId
	 *            the clientReqId to set
	 */
	public void setClientReqId(final String clientReqId) {
		this.clientReqId = clientReqId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(final String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @param paymentHandle
	 *            the paymentHandle to set
	 */
	public void setPaymentHandle(final String paymentHandle) {
		this.paymentHandle = paymentHandle;
	}

	public String getPaymentHandle() {
		return paymentHandle;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * @return the amountReserved
	 */
	public BigDecimal getAmountReserved() {
		return amountReserved;
	}

	/**
	 * @param amountReserved
	 *            the amountReserved to set
	 */
	public void setAmountReserved(final BigDecimal amountReserved) {
		this.amountReserved = amountReserved;
	}

	/**
	 * @return the amountCanceled
	 */
	public BigDecimal getAmountCanceled() {
		return amountCanceled;
	}

	/**
	 * @param amountCanceled
	 *            the amountCanceled to set
	 */
	public void setAmountCanceled(final BigDecimal amountCanceled) {
		this.amountCanceled = amountCanceled;
	}

	/**
	 * @return the amountRefunded
	 */
	public BigDecimal getAmountRefunded() {
		return amountRefunded;
	}

	/**
	 * @param amountRefunded
	 *            the amountRefunded to set
	 */
	public void setAmountRefunded(final BigDecimal amountRefunded) {
		this.amountRefunded = amountRefunded;
	}

	public BigDecimal getAmountCredited() {
		return amountCredited;
	}

	public void setAmountCredited(BigDecimal amountCredited) {
		this.amountCredited = amountCredited;
	}

	/**
	 * @return the pluginCookie
	 */
	public String getPluginCookie() {
		return pluginCookie;
	}

	/**
	 * @param pluginCookie
	 *            the pluginCookie to set
	 */
	public void setPluginCookie(final String pluginCookie) {
		this.pluginCookie = pluginCookie;
	}

	/**
	 * @return the pihash
	 */
	public String getPiHash() {
		return piHash;
	}

	/**
	 * @param pihash
	 *            the pihash to set
	 */
	public void setPiHash(final String pihash) {
		piHash = pihash;
	}

	/**
	 * @return the pmId
	 */
	public String getPmId() {
		return pmId;
	}

	/**
	 * @param pmId
	 *            the pmId to set
	 */
	public void setPmId(final String pmId) {
		this.pmId = pmId;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(final String country) {
		this.country = country;
	}

	/**
	 * @return the amountRequested
	 */
	public BigDecimal getAmountRequested() {
		return amountRequested;
	}

	/**
	 * @param amountRequested
	 *            the amountRequested to set
	 */
	public void setAmountRequested(final BigDecimal amountRequested) {
		this.amountRequested = amountRequested;
	}

	/**
	 * @return the amountPaid
	 */
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	/**
	 * @param amountPaid
	 *            the amountPaid to set
	 */
	public void setAmountPaid(final BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	/**
	 * @return the lockedClientReqId
	 */
	public String getLockedClientReqId() {
		return lockedClientReqId;
	}

	/**
	 * @param lockedClientReqId
	 *            the lockedClientReqId to set
	 */
	public void setLockedClientReqId(final String lockedClientReqId) {
		this.lockedClientReqId = lockedClientReqId;
	}

	/**
	 * @return the lockedDate
	 */
	public Date getLockedDate() {
		return lockedDate;
	}

	/**
	 * @param lockedDate
	 *            the lockedDate to set
	 */
	public void setLockedDate(final Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	/**
	 * @return the businessType
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * @param businessType
	 *            the businessType to set
	 */
	public void setBusinessType(final String businessType) {
		this.businessType = businessType;
	}

	/**
	 * @return the serviceCookie
	 */
	public ServiceCookie getServiceCookie() {
		return serviceCookie;
	}

	/**
	 * @param serviceCookie
	 *            the serviceCookie to set
	 */
	public void setServiceCookie(final ServiceCookie serviceCookie) {
		this.serviceCookie = serviceCookie;
	}

	/* *//**
			 * @return the pmConf
			 */
	/*
	 * public PaymentMethodConfiguration getPmConf() { return pmConf; }
	 * 
	 *//**
		 * @param pmConf
		 *            the pmConf to set
		 *//*
		 * public void setPmConf(final PaymentMethodConfiguration pmConf) {
		 * this.pmConf = pmConf; }
		 */

	/**
	 * @return the plugin
	 */
	public PaymentPlugin getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin
	 *            the plugin to set
	 */
	public void setPlugin(final PaymentPlugin plugin) {
		this.plugin = plugin;
	}

	/* *//**
			 * @return the subAccountConfiguration
			 */
	/*
	 * public PaymentSubAccountConfiguration getSubAccountConfiguration() {
	 * return subAccountConfiguration; }
	 * 
	 *//**
		 * @param subAccountConfiguration
		 *            the subAccountConfiguration to set
		 */
	/*
	 * public void setSubAccountConfiguration(final
	 * PaymentSubAccountConfiguration subAccountConfiguration) {
	 * this.subAccountConfiguration = subAccountConfiguration; }
	 * 
	 *//**
		 * @return the merchantAccountId
		 */
	/*
	 * public String getMerchantAccountId() { if (subAccountConfiguration !=
	 * null) { return subAccountConfiguration.getMerchantAccountId(); } else {
	 * return null; } }
	 * 
	 *//**
		 * @return the divisionId
		 */
	/*
	 * public String getDivisionId() { if (subAccountConfiguration != null) {
	 * return subAccountConfiguration.getDivisionId(); } else { return null; } }
	 * 
	 *//**
		 * @return the endPoint
		 *//*
		 * public String getEndPoint() { if (pmConf != null) { return
		 * pmConf.getEndPointName(); } else { return null; } }
		 */

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(final String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the maxShippable
	 */
	public BigDecimal getMaxShippable() {
		return maxShippable;
	}

	/**
	 * @param maxShippable
	 *            the maxShippable to set
	 */
	public void setMaxShippable(final BigDecimal maxShippable) {
		this.maxShippable = maxShippable;
	}

	/**
	 * @return the maxRefundable
	 */
	public BigDecimal getMaxRefundable() {
		return maxRefundable;
	}

	/**
	 * @param maxRefundable
	 *            the maxRefundable to set
	 */
	public void setMaxRefundable(final BigDecimal maxRefundable) {
		this.maxRefundable = maxRefundable;
	}

	/**
	 * @return the maxCancelable
	 */
	public BigDecimal getMaxCancelable() {
		return maxCancelable;
	}

	/**
	 * @param maxCancelable
	 *            the maxCancelable to set
	 */
	public void setMaxCancelable(final BigDecimal maxCancelable) {
		this.maxCancelable = maxCancelable;
	}

	public String getTestMode() {
		return testMode;
	}

	public void setTestMode(final String testMode) {
		this.testMode = testMode;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the isFinal
	 */
	public Boolean getIsFinal() {
		return isFinal;
	}

	/**
	 * @param isFinal
	 *            the isFinal to set
	 */
	public void setIsFinal(Boolean isFinal) {
		this.isFinal = isFinal;
	}

	/**
	 * @return the daysToExpire
	 */
	public int getDaysToExpire() {
		return daysToExpire;
	}

	/**
	 * @param daysToExpire
	 *            the daysToExpire to set
	 */
	public void setDaysToExpire(int daysToExpire) {
		this.daysToExpire = daysToExpire;
	}

	public Date getAuthExpiryDate() {
		return this.authExpiryDate;
	}

	public void setAuthExpiryDate(Date authExpiryDate) {
		this.authExpiryDate = authExpiryDate;
	}

	/**
	 * @return the activeSplitPayment
	 */
	public String getActiveSplitPayment() {
		return activeSplitPayment;
	}

	/**
	 * @param activeSplitPayment
	 *            the activeSplitPayment to set
	 */
	public void setActiveSplitPayment(String activeSplitPayment) {
		this.activeSplitPayment = activeSplitPayment;
	}

	/**
	 * Don't add any value in ServiceCookie. Add it in CommonCookie. Keep this
	 * class here just not to make many changes in Payment
	 */

	public static class ServiceCookie extends CommonCookie {

	}

	/**
	 * @return the isForceClearing
	 */
	public boolean isForceClearing() {
		return isForceClearing;
	}

	/**
	 * @param isForceClearing
	 *            the isForceClearing to set
	 */
	public void setForceClearning(boolean isForceClearing) {
		this.isForceClearing = isForceClearing;
	}

	/**
	 * @return the isSplitPaymentHandle
	 */
	public boolean isSplitPaymentHandle() {
		return isSplitPaymentHandle;
	}

	/**
	 * @param isSplitPaymentHandle
	 *            the isSplitPaymentHandle to set
	 */
	public void setSplitPaymentHandle(boolean isSplitPaymentHandle) {
		this.isSplitPaymentHandle = isSplitPaymentHandle;
	}

	public String getParentPaymentHandle() {
		return parentPaymentHandle;
	}

	public void setParentPaymentHandle(String parentPaymentHandle) {
		this.parentPaymentHandle = parentPaymentHandle;
	}

	/*
	 * public TenantPluginOperation getTenantPluginOperation() { return
	 * tenantPluginOperation; }
	 * 
	 * public void setTenantPluginOperation(TenantPluginOperation
	 * tenantPluginOperation) { this.tenantPluginOperation =
	 * tenantPluginOperation; }
	 */

	public Boolean getHasChargeback() {
		return hasChargeback;
	}

	public void setHasChargeback(Boolean hasChargeback) {
		this.hasChargeback = hasChargeback;
	}

	/**
	 * @return the piSource
	 */
	public String getPiSource() {
		return piSource;
	}

	/**
	 * @param piSource
	 *            the piSource to set
	 */
	public void setPiSource(String piSource) {
		this.piSource = piSource;
	}

	/**
	 * @return the piSourceReqId
	 */
	public String getPiSourceReqId() {
		return piSourceReqId;
	}

	/**
	 * @param piSourceReqId
	 *            the piSourceReqId to set
	 */
	public void setPiSourceReqId(String piSourceReqId) {
		this.piSourceReqId = piSourceReqId;
	}
}