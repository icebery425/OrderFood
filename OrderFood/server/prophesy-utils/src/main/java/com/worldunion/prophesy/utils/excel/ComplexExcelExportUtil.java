package com.worldunion.prophesy.utils.excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuruiyan on 2017/4/20.
 * 合并报表导出工具类
 */
public class ComplexExcelExportUtil {

    public static String DEFAULT_DATE_PATTERN = "yyyy年MM月dd日";//默认日期格式
    public static int DEFAULT_COLOUMN_WIDTH = 17;


    /**
     *
     * @param tempLatePath  模板绝对路径
     * @param listHeadMap     属性-列头 请使用LinkedHashMap
     * @param headVariableMap
     * @param listJsonArray   数据集
     * @param datePattern 日期格式，传null值则默认 年月日
     * @param colWidth    列宽 默认 至少17个字节
     * @param out         输出流
     */
    private static void exportExcelXByTempLate(String tempLatePath, List<Integer> startRow,List<Integer> startCell,List<LinkedHashMap<String, String>> listHeadMap,Map<String,String> headVariableMap, List<JSONArray> listJsonArray, String datePattern, int colWidth, OutputStream out) {
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


        for (int i = 0; i < listHeadMap.size(); i++) {

            Sheet sheet = workbook.getSheetAt(i);

            //设置列宽
            int minBytes = colWidth < DEFAULT_COLOUMN_WIDTH ? DEFAULT_COLOUMN_WIDTH : colWidth;//至少字节数
            Map<String, String> headMap = listHeadMap.get(i);
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
            int rowIndex = startRow.get(i);

            //替换表头里的变量
            if(headVariableMap!=null){
                for (int x = 0; x < rowIndex; x++) {
                    for (Iterator iter = sheet.getRow(x).cellIterator(); iter.hasNext();) {
                        Cell tempCell = (Cell)iter.next();
                        String cellValue = tempCell.getStringCellValue();
                        if(StringUtils.isNotBlank(cellValue) && cellValue.startsWith("{")){
                            tempCell.setCellValue(headVariableMap.get(cellValue));
                        }
                    }
                }
            }

            // 遍历集合数据，产生数据行
            for (Object obj : listJsonArray.get(i)) {

                JSONObject jo = (JSONObject) JSONObject.toJSON(obj);
                Row dataRow = sheet.createRow(rowIndex);

                for (int j = startCell.get(i); j < properties.length; j++) {
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
     * 使用模板导出excel ，默认为2007版本
     * @param fileName  客户端保存的文件名
     * @param templateName  模板文件名（加后缀） 如：income_received_payments_day.xlsx
     * @param startRow 开始写数据的行号，从0开始
     * @param startCell 开始写数据的列号，从0开始
     * @param listHeadMap       表头键值对
     * @param headVariableMap   表头中变量对应的键值对
     * @param listHeadMap     数据集合
     * @param datePattern   日期格式
     * @param response
     */
    public static void downloadExcelFileByTemplate(String fileName, String templateName, List<Integer> startRow, List<Integer> startCell, List<LinkedHashMap<String, String>> listHeadMap,Map<String,String> headVariableMap, List<JSONArray> listJsonArray, String datePattern, HttpServletResponse response) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            /*String tomcatPath = System.getProperty("user.dir");// /Users/liuruiyan/servers/apache-tomcat-7.0.73/bin
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

            exportExcelXByTempLate(templateFilePath, startRow,startCell,listHeadMap,headVariableMap, listJsonArray, datePattern, 0, os);

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


}
