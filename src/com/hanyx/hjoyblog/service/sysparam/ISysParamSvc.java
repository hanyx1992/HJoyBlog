package com.hanyx.hjoyblog.service.sysparam;

public interface ISysParamSvc {
	public String getValueByCode(String code) throws Exception;
	public String getValueByCodeAndKey(String code,String key);
	public String getValueByKey(String key);
	public void updateValueByCode(String code,String val);
	public void updateValueByCodeAndKey(String code,String key,String val);
	public void updateValueByKey(String key,String val);
}
