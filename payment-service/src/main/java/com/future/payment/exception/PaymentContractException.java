package com.future.payment.exception;

public class PaymentContractException extends RuntimeException {
    private static final long serialVersionUID = 20130704930950292L;
    private String resultReason;
    private String errorMsg;

    public PaymentContractException(final String errorCode) {
        this.resultReason = errorCode;
    }

    public PaymentContractException(final String errorCode, final String errorMsg) {
        this.resultReason = errorCode;
        this.errorMsg = errorMsg;
    }

    public PaymentContractException(final String errorCode, final Exception cause) {
        super(cause);
        this.resultReason = errorCode;
    }

    public PaymentContractException(final String errorCode, final String errorMsg, final Exception cause) {
        super(cause);
        this.resultReason = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getResultReason() {
        return resultReason;
    }

    public void setResultReason(final String resultReason) {
        this.resultReason = resultReason;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(final String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "PaymentContractException [resultReason=" + resultReason + ", errorMsg=" + errorMsg + ", cause()="
                + getCause() + "]";
    }

}
