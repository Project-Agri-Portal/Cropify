package com.cropify.util;

/* 
 Creating this interface to be implemented by the products and machinery class as they are the ones that require
 a custom ID. If in future any other classes requires the custom ID feature then implement this interface and define 
 the inherited methods into that class
 */
public interface Prefixable {
	String getPrefix();
	String getTableName();
	String getIdColName();
}
