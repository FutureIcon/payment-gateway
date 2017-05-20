package com.future.web.dto;

import java.util.ArrayList;

public class ReportPageBean {
   
	private int total;
	
	private ArrayList<PaymentBean> rows = new ArrayList<PaymentBean>();

	public ArrayList<PaymentBean> getRows() {
		return rows;
	}

	public void setRows(ArrayList<PaymentBean> rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	
}
