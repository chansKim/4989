package com.ju.chan;

import java.io.Serializable;

public class ResposeResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMsg;
	public ResposeResult() {

	}
	public ResposeResult(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "ResposeResult [errorCode=" + errorCode + ", errorMsg="
				+ errorMsg + "]";
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
