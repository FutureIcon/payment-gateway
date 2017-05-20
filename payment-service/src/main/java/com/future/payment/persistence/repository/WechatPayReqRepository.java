package com.future.payment.persistence.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.future.payment.persistence.modeling.PayReqData;

//@Repository
public interface WechatPayReqRepository  {
	
//public interface WechatPayReqRepository extends CrudRepository<PayReqData, Long> {

	@Query("select * from payment_request_data where total_fee>0 allow filtering")
	List<PayReqData> findAllReqWithTotalFee();
	
	@Query("select * from payment_request_data where out_trade_no=?0 allow filtering")
	List<PayReqData> findAllReqWithTradeNo(String outTradeNo);
}
