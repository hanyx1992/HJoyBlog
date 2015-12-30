package com.hanyx.hjoyblog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanyx.hjoyblog.bean.Catalog;
import com.hanyx.hjoyblog.service.catalog.ICatalogSvc;
import com.hanyx.hjoyblog.util.DateUtil;

@Controller
public class MainPageController {

	@Autowired
	private MongoTemplate mongoTemplate;

	public ModelAndView toHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("main");
		return mv;
	}

	@Autowired
	private ICatalogSvc iCatalogSvc;

	@RequestMapping(value = "/main.do")
	public String queryAll(HttpServletRequest request) {
		List<Catalog> list = new ArrayList<Catalog>();
		list = iCatalogSvc.queryAll();
		request.setAttribute("catalogList", list);
		return "main";
	}
}
