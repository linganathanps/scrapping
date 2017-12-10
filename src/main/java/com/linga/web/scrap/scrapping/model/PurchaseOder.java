package com.linga.web.scrap.scrapping.model;

import java.util.List;

/**
 * @author linganathan.ps
 *
 */
public class PurchaseOder {

	private String year;
	
	private String AgencyCode;
	
	private String AgencyName;
	
	private List<PurchaseOrderDetails> purchaseDetails;

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the agencyCode
	 */
	public String getAgencyCode() {
		return AgencyCode;
	}

	/**
	 * @param agencyCode the agencyCode to set
	 */
	public void setAgencyCode(String agencyCode) {
		AgencyCode = agencyCode;
	}

	/**
	 * @return the agencyName
	 */
	public String getAgencyName() {
		return AgencyName;
	}

	/**
	 * @param agencyName the agencyName to set
	 */
	public void setAgencyName(String agencyName) {
		AgencyName = agencyName;
	}

	/**
	 * @return the purchaseDetails
	 */
	public List<PurchaseOrderDetails> getPurchaseDetails() {
		return purchaseDetails;
	}

	/**
	 * @param purchaseDetails the purchaseDetails to set
	 */
	public void setPurchaseDetails(List<PurchaseOrderDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PurchaseOder [year=" + year + ", AgencyCode=" + AgencyCode + ", AgencyName=" + AgencyName
				+ ", purchaseDetails=" + purchaseDetails + "]";
	}

}
