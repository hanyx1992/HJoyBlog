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
	/*自定义URL*/
	private String catalogPath;
	/*权限*/
	private short permission;
	/*状态*/
	private short state;
	/*日期*/
	private String createDate;

	public String getCatalogPath() {
		return catalogPath;
	}

	public void setCatalogPath(String catalogPath) {
		this.catalogPath = catalogPath;
	}

	public short getPermission() {
		return permission;
	}

	public void setPermission(short permission) {
		this.permission = permission;
	}
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
