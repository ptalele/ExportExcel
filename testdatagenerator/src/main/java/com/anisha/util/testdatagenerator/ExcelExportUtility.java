package com.anisha.util.testdatagenerator;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public abstract class ExcelExportUtility<E extends Object> {
    protected static final String EMPTY_VALUE = " ";
    protected SXSSFWorkbook wb;
    protected Sheet sh;

    /**
     * This method demonstrates how to Auto resize Excel column
     */
    private void autoResizeColumns(final int listSize) {
        for (int colIndex = 0; colIndex < listSize; colIndex++) {
            sh.autoSizeColumn(colIndex);
        }
    }

    /**
     * This method will return Style of Header Cell
     *
     * @return
     */
    protected CellStyle getHeaderStyle() {
        final CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());

        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return style;
    }

    /**
     * This method will return style for Normal Cell
     *
     * @return
     */
    protected CellStyle getNormalStyle() {
        final CellStyle style = wb.createCellStyle();

        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        return style;
    }

    /**
     * @param columns
     */
    private void fillHeader(final List<String> header) {
    	
        wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        sh = wb.createSheet("Validated Data");
        final CellStyle headerStle = getHeaderStyle();
        for (int rownum = 0; rownum < 1; rownum++) {
            final Row row = sh.createRow(rownum);
            for (int cellnum = 0; cellnum < header.size(); cellnum++) {
            	 final Cell cell = row.createCell(cellnum);
            	 cell.setCellValue(header.get(cellnum));
                 cell.setCellStyle(headerStle);
            }
           
        }
    }

    /**
     * @param columns
     * @param dataList
     * @return
     */
    public final SXSSFWorkbook exportExcel(final List<String> headers, final List<E> dataList) {
        fillHeader(headers);
        fillData(dataList);
        // autoResizeColumns(columns.length);
        return wb;
    }

    /**
     * @param dataList
     */
    abstract void fillData(List<E> dataList);
}