package com.anisha.util.testdatagenerator;

import java.util.List;

//@Data
//@Builder
public class DataRow {
    @Override
	public String toString() {
		return "DataRow [columns=" + columns + "]";
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	List<String> columns;	
}
