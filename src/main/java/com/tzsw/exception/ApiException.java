package com.tzsw.exception;

/**
 * @Author: chenpeng
 * @Description:自定义异常
 * @Date: Created in 11:58 2018/11/21
 */
public class ApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * 错误编码
	 */
	private String errCode;
	
	public ApiException() {
		super();
	}
	
	public ApiException(String message){
		super(message);
	}
	
	public ApiException(String message, Throwable cause){
		super(message, cause);
	}
	
	public ApiException(String errCode, String message){
		super(message);
		this.setErrCode(errCode);
	}
	
	public ApiException(String errCode, String message, Throwable cause){
		super(message, cause);
		this.setErrCode(errCode);
	}

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
}
