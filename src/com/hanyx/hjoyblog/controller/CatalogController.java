package com.hanyx.hjoyblog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hanyx.hjoyblog.bean.Catalog;
import com.hanyx.hjoyblog.service.catalog.ICatalogSvc;

@Controller
public class CatalogController {
	@Autowired
	private ICatalogSvc iCatalogSvc;
	
	public String getAllCatalogId(HttpServletRequest request){
		List<Catalog> list=new ArrayList<Catalog>();
		list=iCatalogSvc.queryAllCatalog();
		request.setAttribute("list",list);
		return "main";
	}
}
