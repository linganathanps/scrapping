package com.linga.web.scrap.scrapping.model;

/**
 * @author linganathan.ps
 *
 */
public class PurchaseOrderDetails {

	private String orderNo;
	
	private String poDate;
	
	private String amount;
	
	private String balance;

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the poDate
	 */
	public String getPoDate() {
		return poDate;
	}

	/**
	 * @param poDate the poDate to set
	 */
	public void setPoDate(String poDate) {
		this.poDate = poDate;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the balance
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseOrderDetails [orderNo=" + orderNo + ", poDate=" + poDate + ", amount=" + amount + ", balance="
				+ balance + "]";
	}
	
}
