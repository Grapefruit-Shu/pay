package com.xishanju.payment.common;


/**
 * 
 * ClassName: ResultSet <br/>
 * Function: TODO <br/>
 * Reason: TODO <br/>
 * @param <T>
 * 
 * @date    2017年2月13日 上午11:00:56
 * @author  huangtao3@meizu.com
 * @version 1.0.0
 * @since   JDK 1.7
 */
public class ResultSet<T> {

	private String code;
	private String msg;
	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	/**
	 * 新建一个结果集
	 * @return
	 */
	public static final <T> ResultSet<T> newResultSet(){
		return new ResultSet<T>();
	}
}
