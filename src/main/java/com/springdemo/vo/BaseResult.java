package com.springdemo.vo;

public class BaseResult<T> {

    /**
     * 返回给页面错误消息
     */

	private String  errorMsg;
    /**
     * 返回给页面错误代码
     */
    private String  errorCode;
    /**
     * 返回页面的数据
     */
    private T       data;
    
    public BaseResult() {
	}
    
	public BaseResult(String errorCode, String errorMsg, T data) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	
	public static BaseResult ok() {
    	BaseResult result = new BaseResult();
    	result.setErrorCode("200");
    	result.setErrorMsg("success");
    	return result;
    }
    
    public static <T> BaseResult<T> ok(T data) {
    	return new BaseResult("200", "success", data);
    }
    
    public static BaseResult fail(String errorCode, String errorMsg) {
    	BaseResult result = new BaseResult();
    	result.setErrorCode(errorCode);
    	result.setErrorMsg(errorMsg);
    	return result;
    }

	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public boolean isSuccess() {
		return "200".equals(getErrorCode());
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
}