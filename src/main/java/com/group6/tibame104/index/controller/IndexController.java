package com.group6.tibame104.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.group6.tibame104.ad.model.AdService;
import com.group6.tibame104.ad.model.AdVO;
import com.group6.tibame104.group.model.GroupService;
import com.group6.tibame104.group.model.GroupVO;
import com.group6.tibame104.groupproduct.model.GroupproductService;
import com.group6.tibame104.groupproduct.model.GroupproductVO;

@Controller
public class IndexController {
	@Autowired
	AdService adService;
	@Autowired
	GroupService groupSvc;
	@Autowired
	GroupproductService groupproductSvc;
	
	@RequestMapping("/")
	public String index(Model model) {
		
//		AdService adService = new AdService();
//		List<AdVO> list = adService.getAll();
//		model.addAttribute("list", list);
		
		 List<GroupVO> groupVOs = groupSvc.getAll();
	     model.addAttribute("groupVOs",groupVOs);
	     List<GroupproductVO> groupproductVOs = groupproductSvc.getAll();
	     model.addAttribute("groupproductVOs",groupproductVOs);
		
		return "/index";
		
	}
}
