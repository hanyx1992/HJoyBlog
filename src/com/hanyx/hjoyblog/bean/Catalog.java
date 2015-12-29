package com.hanyx.hjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * 目录表
 * @author 梅海风
 *
 */
public class Catalog {
	/*目录名*/
	@Id
	private String catalogId;
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	/*自定义URL*/
	private String URL;
	/*权限*/
	private short permission;
	/*状态*/
	private short state;
	/*日期*/
	private String create_date;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public short getPermission() {
		return permission;
	}

	public void setPermission(short permission) {
		this.permission = permission;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
}
