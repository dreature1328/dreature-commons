package com.springboot.data.common.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HTTPResult {

	// 响应码
	private Integer code;
	private String message;
	private Object data;

	public static Map<Integer, String> statusCodes = new HashMap<Integer, String>() {{
		put(100, "继续");
		put(101, "切换协议");
		put(200, "成功");
		put(201, "已创建");
		put(202, "已接受");
		put(204, "无内容");
		put(301, "永久移动");
		put(302, "临时移动");
		put(304, "未修改");
		put(400, "错误请求");
		put(401, "未授权");
		put(403, "禁止访问");
		put(404, "未找到");
		put(500, "内部服务器错误");
		put(501, "未实现");
		put(503, "服务不可用");
	}};

	public HTTPResult(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static HTTPResult success(Object data) {
		return success("", data);
	}
	public static HTTPResult success(String message, Object data) {
		Integer code = 200;
		return new HTTPResult(code, message, data);
	}
	public static HTTPResult fail(Object data) {
		return fail("", data);
	}
	public static HTTPResult fail(String message, Object data) {
		Integer code = 500;
		return new HTTPResult(code, message, data);
	}
	public JSONObject toJSONObject() {
		return (JSONObject) JSON.toJSON(this);
	}

	public String toJSONString() {
		return JSON.toJSONString(this);
	}
}
