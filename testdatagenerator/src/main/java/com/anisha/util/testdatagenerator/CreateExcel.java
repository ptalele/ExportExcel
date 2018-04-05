package com.anisha.util.testdatagenerator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateExcel extends ExcelExportUtility<DataRow> {
    /*
     * @see ExcelExportUtility#fillData(java.util.List)
     */

    void fillData(List<DataRow> dataList) {
        CellStyle normalStyle = getNormalStyle();
        int rowNum = 1;
        for (DataRow dataRow : dataList) {
            Row row = sh.createRow(rowNum);
            int columnIndex = 0;
            for(String column: dataRow.columns) {
                Cell cell_0 = row.createCell(columnIndex);
                cell_0.setCellStyle(normalStyle);
                cell_0.setCellValue(column);
                columnIndex++;
            }
            rowNum++;
        }
    }
}