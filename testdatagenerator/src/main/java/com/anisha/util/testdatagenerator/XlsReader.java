package com.anisha.util.testdatagenerator;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class XlsReader {

    public List<DataRow> read(String path) throws FileNotFoundException {
        InputStream is = new FileInputStream(new File(path));
        Workbook wb = StreamingReader.builder()
                .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);
        List<DataRow> rows = new ArrayList<>();
        for(Row r : wb.getSheetAt(0)) {
            List<String> columns = new ArrayList<>();
            for(Cell c : r) {
                columns.add(c.getStringCellValue());
            }
            DataRow row = DataRow.builder().columns(columns).build();
            rows.add(row);
        }
       return rows;
    }
}
