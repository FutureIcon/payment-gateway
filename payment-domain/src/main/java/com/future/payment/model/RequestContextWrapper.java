package com.future.payment.model;

import java.io.Serializable;
import java.util.Locale;

public class RequestContextWrapper implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer tenantId;

    private Integer verticalId;

    private String localeId;

    private String deviceId;

    private String consumerId;
    
    private String corelationId;

    private Locale locale = null;

    public String getDeviceId() {
        return deviceId;
    }

    
    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(final Integer tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getVerticalId() {
        return verticalId;
    }

    public void setVerticalId(final Integer verticalId) {
        this.verticalId = verticalId;
    }

    public String getLocaleId() {
        return localeId;
    }

    public void setLocaleId(final String localeId) {
        this.localeId = localeId;
    }

    public void setDeviceId(final String deviceId) {
        this.deviceId = deviceId;
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
    
}
