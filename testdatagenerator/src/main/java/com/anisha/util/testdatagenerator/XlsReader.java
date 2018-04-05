package com.anisha.util.testdatagenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.monitorjbl.xlsx.StreamingReader;

@Component
public class XlsReader {

	public ExcelModel readExcelData(String path) throws FileNotFoundException {
		InputStream is = new FileInputStream(new File(path));
		Workbook wb = StreamingReader.builder().rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
				.bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
				.open(is);
		List<DataRow> rows = new ArrayList<>();
		List<String> headers = new ArrayList<>();
		for (Row r : wb.getSheetAt(0)) {
			List<String> columns = new ArrayList<>();
			if (r.getRowNum() == 0) {
				for (Cell c : r) {
					headers.add(c.getStringCellValue());			
				}
			} else {
				for(int i=0; i<headers.size(); i++) {
					Cell c = r.getCell(i);
					if(c==null) {
						columns.add("TBD");
					}else {
						columns.add(c.getStringCellValue());
					}
				}
				
//				for (Cell c : r) {
//					columns.add(c.getStringCellValue());
//				}
				//DataRow row = DataRow.builder().columns(columns).build();
				DataRow row = new DataRow();
				row.setColumns(columns);
				rows.add(row);
			}		
		}
		//ExcelModel model = ExcelModel.builder().header(headers).rows(rows).build();
		ExcelModel model = new ExcelModel();
		model.setHeader(headers);
		model.setRows(rows);
		return model;
	}
}
