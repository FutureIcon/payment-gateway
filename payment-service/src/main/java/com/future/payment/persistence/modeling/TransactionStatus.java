package com.future.payment.persistence.modeling;

public enum TransactionStatus {
	/* Success! */
    SUCCESS,
    /* Initial status or plugin does not know (transaction may or not have happenend) */
    UNKNOWN,
    /* The payment transaction is asynchronous and final state will be updated later */
    PENDING,
    /* The payment transaction went through, but came back with an error (for e.g : not enough funds) */
    PAYMENT_FAILURE,
    /* The payment transaction did not go through, and plugin knows for sure that operation was not even attenpted (for e.g: connection error to gateway) */
    PLUGIN_FAILURE,
    /* Payment Subsystem is off */
    PAYMENT_SYSTEM_OFF;
}
