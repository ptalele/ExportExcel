package com.anisha.util.testdatagenerator;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExportController {

    @Autowired
    private CreateExcel createExcel;
    @Autowired
    private XlsReader xlsReader;

    @GetMapping(value = "/generate")
    public ModelAndView exportRevisionsToExcel(final ModelAndView modelAndView, final HttpServletResponse response) {
        try {
        	//Read the Input XLS
        	long startTime = System.currentTimeMillis();
            final ExcelModel model = xlsReader.readExcelData("C:\\Users\\skmyne6m\\git\\ExportExcel\\testdatagenerator\\src\\main\\resources\\historypharmacyinput-masterAct.xlsx"); //Generate Data Here
            long elapsedTime = (System.currentTimeMillis() - startTime)/1000;
            System.out.println("Reading time : " + elapsedTime +"s");
            System.out.println("Header : " + model.header);
            System.out.println("Row Count : " + model.rows.size());
            
        	//Update the Data Model here
             startTime = System.currentTimeMillis();
             
             DataGenerationUtil.updateDOB(model);
             DataGenerationUtil.updateZip(model);
             DataGenerationUtil.updateCorelationId(model);
             DataGenerationUtil.updateMessgeId(model);
             DataGenerationUtil.updateCustStreetLine1(model);
             DataGenerationUtil.updateCustStreetLine2(model);
             
             elapsedTime = (System.currentTimeMillis() - startTime)/1000;
             System.out.println("Update Data : " + elapsedTime +"s");
             
           
            //Download Data Model
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh_mm_ss");
            final String excelFileName = "Revisions_" + formatter.format(LocalDateTime.now()) + ".xlsx";
            final SXSSFWorkbook wb = createExcel.exportExcel(model.header, model.rows);

            final ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
            wb.write(outByteStream);
            final byte[] outArray = outByteStream.toByteArray();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setContentLength(outArray.length);
            response.setHeader("Expires:", "0"); // eliminates browser caching
            response.setHeader("Content-Disposition", "attachment; filename=" + excelFileName);
            final OutputStream outStream = response.getOutputStream();
            outStream.write(outArray);
            outStream.flush();
            wb.dispose();
            wb.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

    //Use this to create initial random sheet
    private ExcelModel populateRandomData(List<String> headers) {
        final List<DataRow> rows = new ArrayList<>();
        
        for (int i = 0; i < 100000; i++) {
        	List<String> columns= new ArrayList<>();
        	for(int j=0;j<headers.size();j++) {
        		columns.add(DataGenerationUtil.getRandomAlpha(5));
        	}      		
            final DataRow row = new DataRow();
            row.setColumns(columns);
            rows.add(row);
        }
        ExcelModel excelModel = new ExcelModel();
        excelModel.setHeader(headers);
        excelModel.setRows(rows);
        return excelModel;
    }
}
