package com.future.payment.plugin;

import com.future.payment.dto.PayTransactionDTO;

public interface PluginExecutor {
	
	void execute(String identifier, PayTransactionDTO dto);

}
