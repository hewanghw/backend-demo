package com.hw;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    public static Map<String, String> readRoles(String path){

        File file = new File(path);
        if(!file.exists()){
            return null;
        }
        InputStream inputStream = null;
        Map<String, String> map = new HashMap<>();
        try {
            inputStream = new FileInputStream(file);
            Workbook workbook = null;
            if (path.substring(path.lastIndexOf("." )+ 1).equals("xls")){
                workbook = new HSSFWorkbook(inputStream);
            }else if (path.substring(path.lastIndexOf(".") + 1).equals("xlsx")){
                workbook = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                if(cell1 != null){
                  map.put(cell1.getStringCellValue(), cell2.getStringCellValue());
                }
            }
        } catch (Exception e) {
            System.out.println("从用户映射文件中查询用户, 发生异常");
            System.out.println(e.getMessage());
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                    System.out.println("释放资源");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    public static String readByUserguid(String path, String userguid)  {

        File file = new File(path);
        if(!file.exists()){
            return "file not exist";
        }
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            Workbook workbook = null;
            if (path.substring(path.lastIndexOf("." )+ 1).equals("xls")){
                workbook = new HSSFWorkbook(inputStream);
            }else if (path.substring(path.lastIndexOf(".") + 1).equals("xlsx")){
                workbook = new XSSFWorkbook(inputStream);
            }
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                if(cell != null){
                    if(userguid.equals(cell.getStringCellValue())){
                        return row.getCell(1).getStringCellValue();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("从用户映射文件中查询用户, 发生异常");
            System.out.println(e.getMessage());
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                    System.out.println("释放资源");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "userId not exist";
    }
}
