package com.anisha.util.testdatagenerator;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExportController {

    @Autowired
    private CreateExcel createExcel;
    @Autowired
    private XlsReader xlsReader;

    @GetMapping(value = "/export")
    public ModelAndView exportRevisionsToExcel(final ModelAndView modelAndView, final HttpServletResponse response) {
        try {
            final List<DataRow> data = xlsReader.read("/Users/prashant/Downloads/test-input.xlsx"); //Generate Data Here
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_hh_mm_ss");
            final String excelFileName = "Revisions_" + formatter.format(LocalDateTime.now()) + ".xlsx";
            final SXSSFWorkbook wb = createExcel.exportExcel(new String[]{"REVISION ID",
                    "CREATION DATE"}, data);

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

    private List<DataRow> populate() {
        final List<DataRow> rows = new ArrayList<>();
        final List<String> headers = Arrays.asList(
                "fname", "lName", "mname", "dob", "addr", "ph", "src", "id"
        );
        final List<String> column = Arrays.asList(
                "prashat", "talele", "iiiii", "1872-98-23", "10233 concord", "test", "src178", "36788378648"
        );
        rows.add(DataRow.builder().columns(headers).build());
        for (int i = 0; i < 100000; i++) {
            final DataRow row = DataRow.builder().columns(column).build();
            rows.add(row);
        }
        return rows;
    }
}
