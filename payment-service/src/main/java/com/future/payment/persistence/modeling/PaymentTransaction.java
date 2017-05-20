package com.future.payment.persistence.modeling;

import java.math.BigDecimal;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;


//@Table(value = "payment_transaction")
public class PaymentTransaction {
	@PrimaryKeyColumn(name = "attemptId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID attemptId;
	@PrimaryKeyColumn(name = "paymentId", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private UUID paymentId;
	private String transactionExternalKey;

//	@CassandraType(type = Name.VARCHAR)
	private TransactionType transactionType;
	private DateTime effectiveDate;

//	@CassandraType(type = Name.VARCHAR)
	private TransactionStatus transactionStatus;
	
	private BigDecimal amount;
	private String currency;
	private BigDecimal processedAmount;
	private String processedCurrency;
	private String gatewayErrorCode;
	private String gatewayErrorMsg;

	public UUID getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(UUID attemptId) {
		this.attemptId = attemptId;
	}

	public UUID getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(UUID paymentId) {
		this.paymentId = paymentId;
	}

	public String getTransactionExternalKey() {
		return transactionExternalKey;
	}

	public void setTransactionExternalKey(String transactionExternalKey) {
		this.transactionExternalKey = transactionExternalKey;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public DateTime getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(DateTime effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getProcessedAmount() {
		return processedAmount;
	}

	public void setProcessedAmount(BigDecimal processedAmount) {
		this.processedAmount = processedAmount;
	}

	public String getProcessedCurrency() {
		return processedCurrency;
	}

	public void setProcessedCurrency(String processedCurrency) {
		this.processedCurrency = processedCurrency;
	}

	public String getGatewayErrorCode() {
		return gatewayErrorCode;
	}

	public void setGatewayErrorCode(String gatewayErrorCode) {
		this.gatewayErrorCode = gatewayErrorCode;
	}

	public String getGatewayErrorMsg() {
		return gatewayErrorMsg;
	}

	public void setGatewayErrorMsg(String gatewayErrorMsg) {
		this.gatewayErrorMsg = gatewayErrorMsg;
	}

}
