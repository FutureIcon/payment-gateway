package com.future.payment.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public abstract class PayTransactionDTO {

    private PaymentDTO paymentDto = new PaymentDTO();
    private String clientReqId;
    private String transactionType;
    private String resultMessage;
    private String testMode;
    private String secretSauce;
    private BigDecimal amount;
    private String globalTrxnNumber;
    private String clientId;
    private String verticalId;
    private Locale locale;
    private String pmId;
    private String currency;
    private boolean isRedo;
    private String clientSubAccount;
    private String version;
    private String processorTrnxId;
    private CommonResult resultReasonEnum;
    private String initialStatus;
    private String initialResultMessage;
    private CommonResult initalResultReasonEnum;
    private Date txnCreatedDate;
    private String id;
    private boolean isPluginRedo;
    private String consumerId;
    private String corelationId;
    private Boolean isBatchTxn;
    private PaymentDTO parentPaymentDto;
    private String procpi;
    private Map processorInfo;
    private String approvalCode;
    /**
     * @return the resultMessage
     */
    public String getResultMessage() {
        return resultMessage;
    }

    /**
     * @param resultMessage the resultMessage to set
     */
    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isRedo() {
        return isRedo;
    }

    public void setRedo(final boolean isRedo) {
        this.isRedo = isRedo;
    }

    /**
     * @return the payment
     */
    public PaymentDTO getPaymentDto() {
        return paymentDto;
    }

    /**
     * @param payment the payment to set
     */
    public void setPaymentDto(final PaymentDTO payment) {
        paymentDto = payment;
    }

    /**
     * @return the clientReqId
     */
    public String getClientReqId() {
        return clientReqId;
    }

    /**
     * @param clientReqId the clientReqId to set
     */
    public void setClientReqId(final String clientReqId) {
        this.clientReqId = clientReqId;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the testMode
     */
    public String getTestMode() {
        return testMode;
    }

    /**
     * @param testMode the testMode to set
     */
    public void setTestMode(final String testMode) {
        this.testMode = testMode;
    }

    /**
     * @return the secretSauce
     */
    public String getSecretSauce() {
        return secretSauce;
    }

    /**
     * @param secretSauce the secretSauce to set
     */
    public void setSecretSauce(final String secretSauce) {
        this.secretSauce = secretSauce;
    }

    /**
     * @return the amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return the globalTrxnNumber
     */
    public String getGlobalTrxnNumber() {
        return globalTrxnNumber;
    }

    /**
     * @param globalTrxnNumber the globalTrxnNumber to set
     */
    public void setGlobalTrxnNumber(final String globalTrxnNumber) {
        this.globalTrxnNumber = globalTrxnNumber;
    }

    /**
     * @return the paymentHandle
     */
    public String getPaymentHandle() {
        if (paymentDto != null) {
            return paymentDto.getPaymentHandle();
        }
        return null;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Gets the vertical id.
     * 
     * @return the vertical id
     */
    public String getVerticalId() {
        return verticalId;
    }

    /**
     * Sets the vertical id.
     * 
     * @param verticalId the new vertical id
     */
    public void setVerticalId(final String verticalId) {
        this.verticalId = verticalId;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(final String pmId) {
        this.pmId = pmId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    public String getClientSubAccount() {
        return clientSubAccount;
    }

    public void setClientSubAccount(final String clientSubAccount) {
        this.clientSubAccount = clientSubAccount;
    }

    public abstract PayTransactionDTO createInstance();

	public String getProcessorTrnxId() {
        return processorTrnxId;
    }

    public void setProcessorTrnxId(String processorTrnxId) {
        this.processorTrnxId = processorTrnxId;
    }

    public CommonResult getResultReasonEnum() {
		return resultReasonEnum;
	}

	public void setResultReasonEnum(CommonResult resultReasonEnum) {
		this.resultReasonEnum = resultReasonEnum;
	}

	public String getInitialStatus() {
		return initialStatus;
	}

	public void setInitialStatus(String initialStatus) {
		this.initialStatus = initialStatus;
	}

	public String getInitialResultMessage() {
		return initialResultMessage;
	}

	public void setInitialResultMessage(String initialResultMessage) {
		this.initialResultMessage = initialResultMessage;
	}

	public CommonResult getInitalResultReasonEnum() {
		return initalResultReasonEnum;
	}

	public void setInitalResultReasonEnum(
			CommonResult initalResultReasonEnum) {
		this.initalResultReasonEnum = initalResultReasonEnum;
	}

	public Date getTxnCreatedDate() {
		return txnCreatedDate;
	}

	public void setTxnCreatedDate(Date txnCreatedDate) {
		this.txnCreatedDate = txnCreatedDate;
	}

	public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPluginRedo() {
		return isPluginRedo;
	}

	public void setPluginRedo(boolean isPluginRedo) {
		this.isPluginRedo = isPluginRedo;
	}
	
	public String getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}

	public String getCorelationId() {
		return corelationId;
	}

	public void setCorelationId(String corelationId) {
		this.corelationId = corelationId;
	}

	/**
	 * @return the isBatchTxn
	 */
	public Boolean getIsBatchTxn() {
		return isBatchTxn;
	}

	/**
	 * @param isBatchTxn the isBatchTxn to set
	 */
	public void setIsBatchTxn(Boolean isBatchTxn) {
		this.isBatchTxn = isBatchTxn;
	}

	public PaymentDTO getParentPaymentDto() {
		return parentPaymentDto;
	}

	public void setParentPaymentDto(PaymentDTO parentPaymentDto) {
		this.parentPaymentDto = parentPaymentDto;
	}
	

	public String getProcpi() {
		return procpi;
	}

	public void setProcpi(String procpi) {
		this.procpi = procpi;
	}

	public Map getProcessorInfo() {
		return processorInfo;
	}

	public void setProcessorInfo(Map processorInfo) {
		this.processorInfo = processorInfo;
	}
	

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	
	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
}