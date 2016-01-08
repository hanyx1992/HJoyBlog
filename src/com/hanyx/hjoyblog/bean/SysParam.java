package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 系统配置表
 * @author 韩元旭
 */
public class SysParam {

	/** 配置编码 */
	@Id
	private String code;
	/** 配置key,如果没有则和编码一样 */
	private String key;
	/** 配置值 */
	private String value;
	/** 配置描述 */
	private String desc;
	
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
