package com.group6.tibame104.category.model;


//import com.emp.model.EmpVO;

public interface CategoryDAO_interface {
   
     public CategoryVO getbyProductSecID(Integer productSecID);
     public CategoryVO getbyProductMainID(Integer productMainID);
    
}
