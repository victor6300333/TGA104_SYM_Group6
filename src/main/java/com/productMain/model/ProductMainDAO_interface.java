package com.productMain.model;

import java.util.*;

public interface ProductMainDAO_interface {
	/*
	 * 前台 : 1. 需要的是把資料全取出來 丟進去PageContext
	 * 			透過load-on-startup
	 * 
	 * 後台 : for fun 
	 * 
	 * 1. 修改商品大分類 
	 * 2. 刪除商品大分類 
	 * 3. 新增商品大分類 
	 * 4. 把商品大分類全部列出來 
	 * 暫時就用SQL自幹
	 * 
	 */

	public List<ProductMainVO> getAll();

}
