package com.codefty.library.common;

/**
 * 도서 대여 상태 
 * 
 * @author LEE YONGGYO
 */
public enum RentalStatus {
	READY("대기"),
	RENTAL("대여"),
	RETURN("반납") ,
	CHECKING("검수");
	
	protected final String  statusStr;
	
	RentalStatus(String statusStr) {
		this.statusStr = statusStr;
	}
	
	public String getStatusStr() {
		return statusStr;
	}
}