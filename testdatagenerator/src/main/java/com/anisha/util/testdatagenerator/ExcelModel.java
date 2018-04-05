package com.anisha.util.testdatagenerator;

import java.util.List;

//@Data
//@Builder
public class ExcelModel {
	
	List<String> header;
	
	@Override
	public String toString() {
		return "ExcelModel [header=" + header + ", rows=" + rows + "]";
	}
	public List<String> getHeader() {
		return header;
	}
	public void setHeader(List<String> header) {
		this.header = header;
	}
	List<DataRow> rows;
	public List<DataRow> getRows() {
		return rows;
	}
	public void setRows(List<DataRow> rows) {
		this.rows = rows;
	}
}
