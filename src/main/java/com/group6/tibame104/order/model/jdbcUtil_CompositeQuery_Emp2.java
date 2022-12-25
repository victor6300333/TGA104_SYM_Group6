package com.group6.tibame104.order.model;


import java.util.Map;
import java.util.Set;

public class jdbcUtil_CompositeQuery_Emp2 {
	


	public static String get_WhereCondition(Map<String, String> map) {
		Set<String> keys = map.keySet();
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		for (String key : keys) {
			String value = map.get(key);
			if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
				count++;
				

				if ("fromdate".equals(key))
					whereCondition.append("where orderDate between '" + value + " 00:00:00' ");
				else if("todate".equals(key))
					whereCondition.append(" and '" + value + " 23:59:59' ");
				else if("status".equals(key)  )
					whereCondition.append(" && orderStatus = " + value);
				else if("memberID".equals(key)  )
					whereCondition.append(" && memberID = " + value);
				else if("orderID".equals(key)  )
					whereCondition.append("where orderID = " + value);
				System.out.println("key:"+ key + ", value:" + value + ", 次數: " + count);
			}
		}
		
		return whereCondition.toString();
	}


}
