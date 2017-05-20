package com.future.payment.plugin.wechat;

import java.util.Map;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.plugin.AbstractPaymentPlugin;
import com.future.payment.plugin.PluginExecutor;

/**
 * @author cwang12
 * @version 1.0
 * @created 17-Feb-2017 12:45:57 AM
 */
public class WechatPaymentPlugin extends AbstractPaymentPlugin {

	private Map<String, PluginExecutor> pluginExecutorMapper;

	public WechatPaymentPlugin(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * Implement and exposes paypal plugin pay operation to the service.
	 * 
	 * @param request
	 */
	@Override
	public void executeDoPay(PayTransactionDTO dto){
		getPluginExecutorMapper().get(dto.getVersion()).execute(WechatConstants.TRANSACTION_TYPE_PAY, dto);
	}
	
	@Override
	public void executePayDoRefund(PayTransactionDTO dto){
		getPluginExecutorMapper().get(dto.getVersion()).execute(WechatConstants.TRANSACTION_TYPE_REFUND, dto);
	}
	
	@Override
	public void executePayNotification(PayTransactionDTO dto){
		
	}

	public Map<String, PluginExecutor> getPluginExecutorMapper() {
		return pluginExecutorMapper;
	}

	public void setPluginExecutorMapper(Map<String, PluginExecutor> pluginExecutorMapper) {
		this.pluginExecutorMapper = pluginExecutorMapper;
	}


	
}