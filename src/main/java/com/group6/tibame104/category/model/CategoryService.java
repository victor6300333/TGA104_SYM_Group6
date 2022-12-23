package com.group6.tibame104.category.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	CategoryDAO_interface dao;
	
	 public List<CategoryVO> getbyProductSecID(Integer productSecID) {
		return dao.getbyProductSecID(productSecID);
		}
     public List<CategoryVO> getbyProductMainID(Integer productMainID) {
		return dao.getbyProductMainID(productMainID);
		}
}
