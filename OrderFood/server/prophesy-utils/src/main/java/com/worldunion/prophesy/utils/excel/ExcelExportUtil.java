package com.worldunion.prophesy.utils.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuruiyan on 2017/4/17.
 * 简单报表导出工具类，普通表头/模板导出
 */
public class ExcelExportUtil {


    public static String NO_DEFINE = "no_define";//未定义的字段
    public static String DEFAULT_DATE_PATTERN = "yyyy年MM月dd日";//默认日期格式
    public static int DEFAULT_COLOUMN_WIDTH = 17;


    /**
     * 普通excel导出 2003 .xls后缀
     *
     * @param title      标题行
     * @param headMap     属性-列头 请使用LinkedHashMap
     * @param jsonArray  数据中查询出来的数据
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param output     输出流
     */
    private static void exportExcel(String title, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth,OutputStream output) {

        if(datePattern==null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.createInformationProperties();
        workbook.getDocumentSummaryInformation().setCompany("*****公司");
       /* SummaryInformation si = workbook.getSummaryInformation();
        si.setAuthor("JACK");  //填加xls文件作者信息
        si.setApplicationName("导出程序"); //填加xls文件创建程序信息
        si.setLastAuthor("最后保存者信息"); //填加xls文件最后保存者信息
        si.setComments("JACK is a programmer!"); //填加xls文件作者信息
        si.setTitle("POI导出Excel"); //填加xls文件标题信息
        si.setSubject("POI导出Excel");//填加文件主题信息
        si.setCreateDateTime(new Date());*/
        //表头样式
        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        //headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);

        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);

        CellStyle cellStyle_rigth = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle_rigth.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle_rigth.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        cellStyle_rigth.setFont(cellFont);


        CellStyle cellStyle_rigth_percentage = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth_percentage.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth_percentage.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        cellStyle_rigth_percentage.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));

        cellStyle_rigth_percentage.setFont(cellFont);


        // 生成一个(带标题)表格
        HSSFSheet sheet = workbook.createSheet();
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("JACK");
        //设置列宽
        int minBytes = colWidth<DEFAULT_COLOUMN_WIDTH?DEFAULT_COLOUMN_WIDTH:colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext();) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = fieldName;

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] =  bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii,arrColWidth[ii]*256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if(rowIndex == 65535 || rowIndex == 0){
                if ( rowIndex != 0 ) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                if(StringUtils.isNotBlank(title)){
                    HSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                    titleRow.createCell(0).setCellValue(title);
                    titleRow.getCell(0).setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));
                    rowIndex = 1;
                }else{
                    rowIndex = 0;
                }

                HSSFRow headerRow = sheet.createRow(rowIndex); //列头 rowIndex =1
                for(int i=0;i<headers.length;i++)
                {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);

                }
                rowIndex++;//数据内容从 rowIndex+1开始
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            HSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++)
            {
                HSSFCell newCell = dataRow.createCell(i);

                Object o =  jo.get(properties[i]);
                String cellValue = "";
                Double cellValueDouble = null;

                if (o == null) {
                    cellValue = "--";
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle_rigth);
                }else if (o instanceof Date){
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle);
                }else if (o instanceof Float || o instanceof Double || o instanceof BigDecimal){
                    cellValueDouble = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    newCell.setCellValue(cellValueDouble);
                    newCell.setCellStyle(cellStyle_rigth);
                }else{
                    cellValue = o.toString();
                    newCell.setCellValue(cellValue);
                    if(cellValue.contains("%")){
                        newCell.setCellStyle(cellStyle_rigth_percentage);
                    }else{
                        newCell.setCellStyle(cellStyle);
                    }
                }
            }
            rowIndex++;
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(output);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    /**
     * 导出Excel 2007 OOXML (.xlsx)格式
     *
     * @param title       标题行
     * @param headMap     属性-列头 请使用LinkedHashMap
     * @param jsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    private static void exportExcelX(String title, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth, OutputStream out) {
        if (datePattern == null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
        //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        //headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);

        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);

        CellStyle cellStyle_rigth = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle_rigth.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle_rigth.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        cellStyle_rigth.setFont(cellFont);


        CellStyle cellStyle_rigth_percentage = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth_percentage.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth_percentage.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        cellStyle_rigth_percentage.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));

        cellStyle_rigth_percentage.setFont(cellFont);




        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();
        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext(); ) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }
        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if (rowIndex == 65535 || rowIndex == 0) {
                if (rowIndex != 0) sheet = workbook.createSheet();//如果数据超过了，则在第二页显示

                if(StringUtils.isNotBlank(title)){
                    SXSSFRow titleRow = sheet.createRow(0);//表头 rowIndex=0
                    titleRow.createCell(0).setCellValue(title);
                    titleRow.getCell(0).setCellStyle(titleStyle);
                    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, headMap.size() - 1));
                    rowIndex = 1;
                }else{
                    rowIndex = 0;
                }

                SXSSFRow headerRow = sheet.createRow(rowIndex); //列头 rowIndex =1
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);

                }
                rowIndex++;//数据内容从 rowIndex+1开始
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            SXSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++) {
                SXSSFCell newCell = dataRow.createCell(i);
                Object o = jo.get(properties[i]);
                String cellValue = "";
                Double cellValueDouble = null;

                if (o == null) {
                    cellValue = "--";
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle_rigth);
                }else if (o instanceof Date){
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle);
                }else if (o instanceof Float || o instanceof Double || o instanceof BigDecimal){
                    cellValueDouble = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    newCell.setCellValue(cellValueDouble);
                    newCell.setCellStyle(cellStyle_rigth);
                }else{
                    cellValue = o.toString();
                    newCell.setCellValue(cellValue);
                    if(cellValue.contains("%")){
                        newCell.setCellStyle(cellStyle_rigth_percentage);
                    }else{
                        newCell.setCellStyle(cellStyle);
                    }
                }
            }
            rowIndex++;
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(out);
            workbook.close();
            workbook.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /**
     * 读取模板
     * @param tempLatePath
     * @return
     */
    private static Workbook readerWorkBookTemplate(String tempLatePath){

        File file = new File(tempLatePath);
        InputStream input= null;
        try {
             input=new FileInputStream(new File(tempLatePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Workbook workbook = null;
        if(file.exists()){
            try {
                workbook = new XSSFWorkbook(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return workbook;
    }


    /**
     *
     * @param tempLatePath  模板绝对路径
     * @param startRow 开始写数据的行号，从0开始
     * @param startCell 开始写数据的列号，从0开始
     * @param headMap     属性-列头 请使用LinkedHashMap
     * @param jsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    private static void exportExcelXByTempLate(String tempLatePath, int startRow,int startCell,Map<String, String> headMap,JSONArray jsonArray, String datePattern, int colWidth, OutputStream out) {
        if (datePattern == null) datePattern = DEFAULT_DATE_PATTERN;

        File file = new File(tempLatePath);
        Workbook workbook = null;
        InputStream input= null;
        if(file.exists()){
            try {
                input=new FileInputStream(file);
                workbook = new XSSFWorkbook(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("导出文件报错，模板文件不存在！！！！！！！！");
            return;
        }


        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);

        CellStyle cellStyle_rigth = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle_rigth.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle_rigth.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        cellStyle_rigth.setFont(cellFont);


        CellStyle cellStyle_rigth_percentage = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth_percentage.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth_percentage.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        cellStyle_rigth_percentage.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));

        cellStyle_rigth_percentage.setFont(cellFont);



        Sheet sheet = workbook.getSheetAt(0);

        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int headNumberSize = headMap.size();
        int[] arrColWidth = new int[headNumberSize];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headNumberSize];
        String[] headers = new String[headNumberSize];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext(); ) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }

            //从第三列开始写数据
            int rowIndex = startRow;

            //替换表头里的变量
            /*if(headVariableMap!=null){
                for (int x = 0; x < rowIndex; x++) {
                    for (Iterator iter = sheet.getRow(x).cellIterator(); iter.hasNext();) {
                        Cell tempCell = (Cell)iter.next();
                        String cellValue = tempCell.getStringCellValue();
                        if(StringUtils.isNotBlank(cellValue) && cellValue.startsWith("{")){
                            tempCell.setCellValue(headVariableMap.get(cellValue));
                        }
                    }
                }
            }*/

            // 遍历集合数据，产生数据行
            for (Object obj : jsonArray) {

                JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
                Row dataRow = sheet.createRow(rowIndex);
                for (int j = startCell; j < properties.length; j++) {
                    Cell newCell = dataRow.createCell(j);
                    Object o = jo.get(properties[j]);
                    String cellValue = "";
                    Double cellValueDouble = null;

                    if (o == null) {
                        cellValue = "--";
                        newCell.setCellValue(cellValue);
                        newCell.setCellStyle(cellStyle_rigth);
                    }else if (o instanceof Date){
                        cellValue = new SimpleDateFormat(datePattern).format(o);
                        newCell.setCellValue(cellValue);
                        newCell.setCellStyle(cellStyle);
                    }else if (o instanceof Float || o instanceof Double || o instanceof BigDecimal){
                        cellValueDouble = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        newCell.setCellValue(cellValueDouble);
                        newCell.setCellStyle(cellStyle_rigth);
                    }else{
                        cellValue = o.toString();
                        newCell.setCellValue(cellValue);
                        if(cellValue.contains("%")){
                            newCell.setCellStyle(cellStyle_rigth_percentage);
                        }else{
                            newCell.setCellStyle(cellStyle);
                        }
                    }

                }
                rowIndex++;
            }


        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/

        try {
            workbook.write(out);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 复杂表头 导出Excel 2007 OOXML (.xlsx)格式
     *
     * @param headersValue 标题行，每一行是一个String[]，有几行标题，就往list里add
     * @param headerCoordinate  标题行一个单元格要合并的坐标
     * @param headMap     属性-列头 请使用LinkedHashMap
     * @param jsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    private static void exportExcelXByComplexHeader(List<String[]> headersValue,List<String[]> headerCoordinate, Map<String, String> headMap, JSONArray jsonArray, String datePattern, int colWidth, OutputStream out) {
        if (datePattern == null) datePattern = DEFAULT_DATE_PATTERN;
        // 声明一个工作薄
        SXSSFWorkbook workbook = new SXSSFWorkbook(1000);//缓存
        workbook.setCompressTempFiles(true);
        //表头样式
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 列头样式
        CellStyle headerStyle = workbook.createCellStyle();
        //headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        headerStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中

        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        Font cellFont = workbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);

        CellStyle cellStyle_rigth = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth.setBorderTop(HSSFCellStyle.BORDER_THIN);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle_rigth.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle_rigth.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        cellStyle_rigth.setFont(cellFont);


        CellStyle cellStyle_rigth_percentage = workbook.createCellStyle();
        //cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle_rigth_percentage.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle_rigth_percentage.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平方向的对齐方式,默认居左（字符串）
        cellStyle_rigth_percentage.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

        cellStyle_rigth_percentage.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));

        cellStyle_rigth_percentage.setFont(cellFont);




        // 生成一个(带标题)表格
        SXSSFSheet sheet = workbook.createSheet();

        //冻结表头
        //sheet.createFreezePane(3, 2, 3, 2);


        //设置列宽
        int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
        int[] arrColWidth = new int[headMap.size()];
        // 产生表格标题行,以及设置列宽
        String[] properties = new String[headMap.size()];
        String[] headers = new String[headMap.size()];
        int ii = 0;
        for (Iterator<String> iter = headMap.keySet().iterator(); iter
                .hasNext(); ) {
            String fieldName = iter.next();

            properties[ii] = fieldName;
            headers[ii] = headMap.get(fieldName);

            int bytes = fieldName.getBytes().length;
            arrColWidth[ii] = bytes < minBytes ? minBytes : bytes;
            sheet.setColumnWidth(ii, arrColWidth[ii] * 256);
            ii++;
        }

        //写列头
        readHeader(headersValue,headerCoordinate,headerStyle,sheet);

        // 遍历集合数据，产生数据行
        int rowIndex = 0;
        for (Object obj : jsonArray) {
            if (rowIndex == 65535 || rowIndex == 0) {
                if (rowIndex != 0) {
                    sheet = workbook.createSheet();//如果数据超过了，则在第二页显示
                    //冻结表头
                    //sheet.createFreezePane(3, 2, 3, 2);
                    //写列头
                    readHeader(headersValue,headerCoordinate,headerStyle,sheet);
                }

                //内容开始行
                rowIndex = headersValue.size();

            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
            SXSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++) {
                SXSSFCell newCell = dataRow.createCell(i);
                Object o = jo.get(properties[i]);
                String cellValue = "";
                Double cellValueDouble = null;

                if (o == null) {
                    cellValue = "--";
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle_rigth);
                }else if (o instanceof Date){
                    cellValue = new SimpleDateFormat(datePattern).format(o);
                    newCell.setCellValue(cellValue);
                    newCell.setCellStyle(cellStyle);
                }else if (o instanceof Float || o instanceof Double || o instanceof BigDecimal){
                    cellValueDouble = new BigDecimal(o.toString()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    newCell.setCellValue(cellValueDouble);
                    newCell.setCellStyle(cellStyle_rigth);
                }else{
                    cellValue = o.toString();
                    newCell.setCellValue(cellValue);
                    if(cellValue.contains("%")){
                        newCell.setCellStyle(cellStyle_rigth_percentage);
                    }else{
                        newCell.setCellStyle(cellStyle);
                    }
                }
            }
            rowIndex++;
        }
        // 自动调整宽度
        /*for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }*/
        try {
            workbook.write(out);
            workbook.close();
            workbook.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void readHeader(List<String[]> headersValue,List<String[]> headerCoordinate,CellStyle headerStyle,SXSSFSheet sheet){

        //先写表头
        for (int i = 0; i < headersValue.size(); i++) {
            SXSSFRow headerRow = sheet.createRow(i); //列头
            String[] headerValue = headersValue.get(i);

            for (int j = 0; j < headerValue.length; j++) {
                SXSSFCell cell = headerRow.createCell(j);
                cell.setCellStyle(headerStyle);
                if(StringUtils.isNotBlank(headerValue[j])){
                    cell.setCellValue(headerValue[j]);
                }
            }
        }

        //再统一做合并
        for (int i = 0; i < headerCoordinate.size(); i++) {

            String[] tempHeaderCoordinate = headerCoordinate.get(i);
            //动态合并单元格
            for (int j = 0; j < tempHeaderCoordinate.length; j++) {
                String[] temp = tempHeaderCoordinate[j].split(",");
                Integer startrow = Integer.parseInt(temp[0]);
                Integer overrow = Integer.parseInt(temp[1]);
                Integer startcol = Integer.parseInt(temp[2]);
                Integer overcol = Integer.parseInt(temp[3]);
                sheet.addMergedRegion(new CellRangeAddress(startrow, overrow,
                        startcol, overcol));
            }
        }

        //是否需要：最后给合并的表头统一设置样式
        // 遍历合并区域
        /*for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress region = sheet.getMergedRegion(i); //
            int colIndex = region.getFirstColumn();             // 合并区域首列位置
            int rowNum = region.getFirstRow();

            sheet.getRow(rowNum).getCell(colIndex).setCellStyle(headerStyle);
            // 合并区域首行位置
            //System.out.println("第[" + i + "]个合并区域：" +  sheet.getRow(rowNum).getCell(colIndex).getStringCellValue());
        }*/


    }


    /**
     *  简单表头导出excel
     * @param excelVersion  excel版本： 2003，2007，不传默认为2007
     * @param fileName      文件名
     * @param title         标题  若为空，则没有第一行的标题
     * @param headMap       表头
     * @param ja            数据
     * @param datePattern   时间格式  yyyy-MM-dd HH:mm:ss 默认为yyyy年MM月dd日
     * @param response
     */
    public static void downloadExcelFile(String excelVersion,String fileName, String title,LinkedHashMap<String, String> headMap, JSONArray ja,String datePattern, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            if(StringUtils.isBlank(excelVersion)){
                excelVersion = "2007";
            }

            if(excelVersion.equals("2003")){
                ExcelExportUtil.exportExcel(title, headMap, ja, datePattern, 0, os);
            }else{
                ExcelExportUtil.exportExcelX(title, headMap, ja, datePattern, 0, os);
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *  复杂表头导出excel
     * @param excelVersion  excel版本： 2003，2007，不传默认为2007
     * @param fileName      文件名
     * @param title         标题  若为空，则没有第一行的标题
     * @param headMap       表头
     * @param ja            数据
     * @param datePattern   时间格式  yyyy-MM-dd HH:mm:ss 默认为yyyy年MM月dd日
     * @param response
     */
    public static void downloadExcelFileByComplexHeader(String excelVersion,String fileName, List<String[]> headersValue,List<String[]> headerCoordinate,String title,LinkedHashMap<String, String> headMap, JSONArray ja,String datePattern, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            if(StringUtils.isBlank(excelVersion)){
                excelVersion = "2007";
            }

            //写数据
            ExcelExportUtil.exportExcelXByComplexHeader(headersValue,headerCoordinate, headMap, ja, datePattern, 0, os);

            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 使用模板导出excel ，默认为2007版本
     * @param fileName  客户端保存的文件名
     * @param templateName  模板文件名（加后缀） 如：income_received_payments_day.xlsx
     * @param startRow 开始写数据的行号，从0开始
     * @param startCell 开始写数据的列号，从0开始
     * @param headMap       表头键值对
     * @param jsonArray     数据集合
     * @param datePattern   日期格式
     * @param response
     */
    public static void downloadExcelFileByTemplate(String fileName, String templateName,int startRow,int startCell,LinkedHashMap<String, String> headMap,JSONArray jsonArray,String datePattern, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();


           /* String tomcatPath = System.getProperty("user.dir");// /Users/liuruiyan/servers/apache-tomcat-7.0.73/bin
            if(tomcatPath.endsWith("bin")){
                tomcatPath = tomcatPath.replace("bin","");
            }else if(tomcatPath.endsWith("bin/")){
                tomcatPath = tomcatPath.replace("bin/","");
            }

            String projectName = ExcelConfig.getProjectName();
            if(StringUtils.isBlank(projectName)){
                projectName = "ROOT";
            }

            String templateFilePath = tomcatPath+"webapps/"+projectName+"/excelTemplate/"+templateName;*/

            // /Users/liuruiyan/IdeaProjects/BI/wubi-web/target/wubi-web/WEB-INF/classes/
            String classesPath = new ExcelExportUtil().getClass().getResource("/").getPath();
            classesPath = classesPath.replace("WEB-INF/classes/","");
            String templateFilePath = classesPath+"/excelTemplate/"+templateName;

            ExcelExportUtil.exportExcelXByTempLate(templateFilePath, startRow,startCell,headMap, jsonArray, datePattern, 0, os);

            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            
            response.setHeader("Content-Type","application/msexcel");
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName+ ".xlsx"));
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
//            response.setHeader("Content-Disposition", "attachment;filename=" + new String((fileName + ".xlsx").getBytes(), "iso-8859-1"));
            response.setContentLength(content.length);
            ServletOutputStream outputStream = response.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            BufferedOutputStream bos = new BufferedOutputStream(outputStream);
            byte[] buff = new byte[8192];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);

            }
            bis.close();
            bos.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        int count = 100;
        JSONArray jsonArray = new JSONArray();
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 100; i++) {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("date",new Date());
            map.put("region","深圳"+i);
            map.put("server1","server1"+i);
            map.put("server2","server2"+i);
            map.put("server3","server3"+i);
            map.put("server4","server4"+i);
            map.put("server5","server5"+i);
            map.put("server6","serve6"+i);
            map.put("server7","server7"+i);
            map.put("server8","server8"+i);
            jsonArray.add(map);
        }

        String[] header01 = new String[] { "日期", "地区", "创收", "", "", "", "", "", "回款", ""};//在excel中的第3行每列的参数
        String[] header02 = new String[] { "", "", "代理业务", "存量业务","房联宝", "自营物管", "装修", "工商资产运营", "顾问", "公寓"};//在excel中的第4行每列（合并列）的参数
        String[] headnum0 = new String[] { "0,0,2,7", "0,0,8,9"};//对应excel中的行和列，下标从0开始{"开始行,结束行,开始列,结束列"}
        String[] headnum1 = new String[] { "0,1,0,0", "0,1,1,1"};

        List<String[]> headersValue = new ArrayList<String[]>();
        List<String[]> headersCoordinate = new ArrayList<String[]>();
        headersValue.add(header01);
        headersValue.add(header02);

        headersCoordinate.add(headnum0);
        headersCoordinate.add(headnum1);

        Map<String, String> headMap = new LinkedHashMap<String, String>();
        headMap.put("date", "日期");
        headMap.put("region", "地区");
        headMap.put("server1", "代理业务");
        headMap.put("server2", "存量业务");
        headMap.put("server3", "房联宝");
        headMap.put("server4", "自营物管");
        headMap.put("server5", "装修");
        headMap.put("server6", "工商资产运营");
        headMap.put("server7", "顾问");
        headMap.put("server8", "公寓");


        //String templateFilePath = "/Users/liuruiyan/servers/apache-tomcat-7.0.73/webapps/ROOT/excelTemplate/sales_management_day.xlsx";
        String templateFilePath = "/Users/liuruiyan/work/worldunion/bi/bi导出模板/income_received_payments_day.xlsx";

        FileOutputStream outXlsx = new FileOutputStream("/Users/liuruiyan/work/worldunion/bi/template.xlsx");
        System.out.println("正在导出xlsx....");
        Date d2 = new Date();
        //ExcelExportUtil.exportExcelXByTempLate(templateFilePath, 2,0,headMap,jsonArray, "yyyy-MM-dd", 0, outXlsx);
        ExcelExportUtil.exportExcelXByComplexHeader(headersValue,headersCoordinate,headMap,jsonArray,null,0,outXlsx);

        //ExcelExportUtil.downloadExcelFileByComplexHeader(null,"复杂表头自动生成测试",headersValue,headersCoordinate,null,headMap,jsonArray,null)

        System.out.println("共" + count + "条数据,执行" + (new Date().getTime() - d2.getTime()) + "ms");
        outXlsx.close();

    }


    public static void testPath(){
        System.out.println(new ExcelExportUtil().getClass().getResource("/").getPath());
    }

}
/*class Student {
    private String name;
    private int age;
    private Date birthday;
    private float height;
    private double weight;
    private boolean sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}*/

