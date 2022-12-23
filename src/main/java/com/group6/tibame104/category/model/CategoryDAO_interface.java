package com.group6.tibame104.category.model;

import java.util.List;

//import com.emp.model.EmpVO;

public interface CategoryDAO_interface {
   
     public List<CategoryVO> getbyProductSecID(Integer productSecID);
     public List<CategoryVO> getbyProductMainID(Integer productMainID);
    
}
