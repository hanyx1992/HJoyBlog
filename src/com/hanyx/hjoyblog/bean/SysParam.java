package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 系统配置表
 * @author 韩元旭
 */
public class SysParam {

	@Id
	private String id;
	
	private String code;
	private String key;
	private String value;
	private String desc;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
