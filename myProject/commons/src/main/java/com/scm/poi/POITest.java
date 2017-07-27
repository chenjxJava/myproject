package com.scm.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Created by admin on 2017-06-19.
 */
public class POITest {
    public static void main(String[] args) throws Exception{
        //demo1();
        demo2();

    }

    private static void demo2() throws IOException {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        Row row = sheet.createRow((short)2);
        row.createCell(0).setCellValue(1.1);
        row.createCell(1).setCellValue(new Date());
        row.createCell(2).setCellValue(Calendar.getInstance());
        row.createCell(3).setCellValue("a string");
        row.createCell(4).setCellValue(true);
        row.createCell(5).setCellType(HSSFCell.CELL_TYPE_ERROR);
        //将输出流写入一个文件
        FileOutputStream fileOut = new FileOutputStream("workbook.xls");
        wb.write(fileOut);
        fileOut.close();
    }

    private static void demo1() throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("first");

        HSSFSheet sheet1 = wb.createSheet("second");
        int num = wb.getNumberOfSheets();
        System.out.println(num);

        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        row.createCell(0).setCellStyle(cellStyle);
        row.createCell(0).setCellValue(1);

        FileOutputStream fos = new FileOutputStream("first.xls");
        wb.write(fos);
        fos.close();
    }
}
