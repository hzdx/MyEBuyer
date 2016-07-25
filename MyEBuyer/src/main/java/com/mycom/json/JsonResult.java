package com.mycom.json;

import java.util.HashMap;

public class JsonResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 7759653507930555173L;
	private static final String KEY_MESSAGE = "message";
	private static final String STATUS_MESSAGE = "status";

	public enum STATUS {
		OK, FAIL
	}

	public static final JsonResult OK = new JsonResult(STATUS.OK);
	public static final JsonResult FAIL = new JsonResult(STATUS.FAIL);

	@SuppressWarnings("unused")
	private JsonResult() {
	}

	/**
	 * 
	 * 构造包含 status 的JsonResult
	 * 
	 */
	public JsonResult(STATUS status) {
		super();
		put(STATUS_MESSAGE, status.name().toLowerCase());
	}

	public JsonResult(STATUS status, String message) {
		this(status);
		put(KEY_MESSAGE, message);
	}

	public JsonResult put(String key, Object value) {
		if (this == JsonResult.OK || this == JsonResult.FAIL) {
			JsonResult jr = (JsonResult) this.clone();// 不能改变静态常量里面的内容，只能克隆一个
			jr.put(key, value);
			return jr;
		} else {
			put(key, value);
			return this;
		}
	}

	public JsonResult message(String message) {
		return put(KEY_MESSAGE, message);
	}

	@Override
	public Object clone() {
		return super.clone();
	}

}