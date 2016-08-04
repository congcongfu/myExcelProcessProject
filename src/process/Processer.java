package process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import model.LogisticRecord;
import model.Result;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月4日
 */
public class Processer {

    public static String outputFile = "/Users/mishi/result.xls";
    public static String RECORDPATH = "/Users/mishi/sqlResult_712259.csv";
    public static String DATAPATH   = "/Users/mishi/data8.xls";

    /**
     * 
     * 
     * @param args
     * @return void
     * @since v2.2.2
     * 
     * <PRE>
     * 1621210001688490
     * author 傅聪 
     * Date 2016年8月3日
     * </PRE>
     */
    public static void main(String[] args) {
        File file = new File(DATAPATH);
        Map<String, LogisticRecord> dataMap = new HashMap<String, LogisticRecord>();
        Map<String, String> recordMap = new HashMap<String, String>();
        List<LogisticRecord> resultList = new ArrayList<LogisticRecord>();
        recordMap = getResultMapFromCvs(RECORDPATH); // 总关系表
        // 获取第一张Sheet表
        dataMap = getLogisticRecordMap(file); // 需要比较的 表

        for (String plantform_logistics_id : dataMap.keySet()) {
            if (recordMap.containsKey(plantform_logistics_id)) {
                String out_logistics_id = recordMap.get(plantform_logistics_id); //
                LogisticRecord logisticRecord = dataMap.get(plantform_logistics_id);
                if (!out_logistics_id.equals(logisticRecord.getOut_logistics_id())) {
                    System.out.println(" Record" + " plantform_logistics_id= " + plantform_logistics_id
                                       + " out_logistics_id=" + out_logistics_id);
                    System.out.println(" logisticRecord  plantform_logistics_id="
                                       + logisticRecord.getPlantform_logistics_id() + " out_logistics_id= "
                                       + logisticRecord.getOut_logistics_id());
                    System.out.println("/n");
                    logisticRecord.setPlantform_logistics_id_our(plantform_logistics_id);
                    logisticRecord.setOut_logistics_id_our(out_logistics_id);
                    resultList.add(logisticRecord);
                }
            }
        }
//        for (String out_logistics_id : dataMap.keySet()) {
//            if (recordMap.containsKey(out_logistics_id)) {
//                String plantform_logistics_id = recordMap.get(out_logistics_id); // 获取纪录
//                LogisticRecord logisticRecord = dataMap.get(out_logistics_id);
//                if (!plantform_logistics_id.equals(logisticRecord.getPlantform_logistics_id())) {
//                    System.out.println(" Record" + " plantform_logistics_id= " + plantform_logistics_id
//                                       + " out_logistics_id=" + out_logistics_id);
//                    System.out.println(" logisticRecord  plantform_logistics_id="
//                                       + logisticRecord.getPlantform_logistics_id() + " out_logistics_id= "
//                                       + logisticRecord.getOut_logistics_id());
//                    System.out.println("/n");
//                    logisticRecord.setPlantform_logistics_id_our(plantform_logistics_id);
//                    logisticRecord.setOut_logistics_id_our(out_logistics_id);
//                    resultList.add(logisticRecord);
//                }
//            }
//        }
        writeData(resultList);
    }

    /**
     * 
     * 读excel文件
     * 
     * @param file
     * @return
     * @return Map<String,LogisticRecord>
     * @since v2.2.2
     * 
     * <PRE>
     * author 傅聪 
     * Date 2016年8月3日
     * </PRE>
     */
    public static Map<String, LogisticRecord> getLogisticRecordMap(File file) {

        Map<String, LogisticRecord> dataMap = new HashMap<String, LogisticRecord>();
        try {
            InputStream in = new FileInputStream(file);
            Workbook workbook = Workbook.getWorkbook(in);
            Sheet sheet = workbook.getSheet(0); // 获得第一个工作表对象

            for (int i = 0; i < sheet.getRows(); i++) {
                LogisticRecord logisticRecord = new LogisticRecord();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i); // 获得单元格
                    switch (j) {
                        case 0:
                            logisticRecord.setFinishTime(cell.getContents());
                            break;
                        case 1:
                            logisticRecord.setOut_logistics_id(cell.getContents());
                            break;
                        case 2:
                            logisticRecord.setOrderStatus(cell.getContents());
                            break;
                        case 3:
                            logisticRecord.setCity(cell.getContents());
                            break;
                        case 4:
                            logisticRecord.setCustomeNum(cell.getContents());
                            break;
                        case 5:
                            logisticRecord.setMoney(cell.getContents());
                            break;
                        case 6:
                            logisticRecord.setDistance(cell.getContents());
                            break;
                        case 7:
                            logisticRecord.setTransportFee(cell.getContents());
                            break;
                        case 8:
                            logisticRecord.setDeliverScop(cell.getContents());
                            break;
                        case 9:
                            logisticRecord.setOrderType(cell.getContents());
                            break;
                        case 10:
                            logisticRecord.setPlantform_logistics_id(cell.getContents());
                            break;
                        default:
                            ;
                    }
                }
                dataMap.put(logisticRecord.getPlantform_logistics_id(), logisticRecord);
//                dataMap.put(logisticRecord.getOut_logistics_id(), logisticRecord); // 反过来
                System.out.print("\n");
            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataMap;
    }

    /**
     * 
     * 
     * 
     * @return
     * @return Map<String,String>
     * @since v2.2.2
     * 
     * <PRE>
     * author 傅聪 
     * Date 2016年8月4日
     * </PRE>
     */
    public static Map<String, String> getResultMapFromCvs(String path) {
        Map<String, String> dataMap = new HashMap<String, String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));// 换成你的文件名
            reader.readLine();// 第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");// CSV格式文件为逗号分隔符文件，这里根据逗号切分

                String plantform_logistics_id = item[1];
                plantform_logistics_id = plantform_logistics_id.substring(1, plantform_logistics_id.length() - 1);
                String out_logistics_id = item[2];
                out_logistics_id = out_logistics_id.substring(1, out_logistics_id.length() - 1);
                dataMap.put(plantform_logistics_id, out_logistics_id);
//                dataMap.put(out_logistics_id, plantform_logistics_id); // 反过来 1674710002147390
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataMap;
    }

    /**
     * 
     * 
     * 
     * @param file
     * @return
     * @return Map<String,LogisticRecord>
     * @since v2.2.2
     * 
     * <PRE>
     * author 傅聪 
     * Date 2016年8月3日
     * </PRE>
     */
    public static Map<String, String> getResultMap(File file) {

        Map<String, String> dataMap = new HashMap<String, String>();
        try {
            InputStream in = new FileInputStream(file);
            Workbook workbook = Workbook.getWorkbook(in);
            Sheet sheet = workbook.getSheet(0); // 获得第一个工作表对象

            for (int i = 0; i < sheet.getRows(); i++) {
                Result record = new Result();
                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i); // 获得单元格
                    switch (j) {
                        case 0:
                            break;
                        case 1:
                            record.setPlantform_logistics_id(cell.getContents());
                            break;
                        case 2:
                            record.setOut_logistics_id(cell.getContents());
                            break;
                        default:
                            ;
                    }
                }
                dataMap.put(record.getPlantform_logistics_id(), record.getOut_logistics_id());
                System.out.print("\n");
            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataMap;
    }

    /**
     * 
     * 
     * @return
     * @return void
     * @since v2.2.2
     * 
     * <PRE>
     * author 傅聪 
     * Date 2016年8月4日
     * </PRE>
     */
    public static void writeData(List<LogisticRecord> logisticRecordList) {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();

            HSSFSheet sheet = workbook.createSheet();
            for (int i = 0; i < logisticRecordList.size(); i++) {
                LogisticRecord logisticRecord = logisticRecordList.get(i);
                HSSFRow row = sheet.createRow((short) i);

                HSSFCell cell1 = row.createCell((short) 0);
                cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell1.setCellValue(logisticRecord.getFinishTime());

                HSSFCell cell2 = row.createCell((short) 1);
                cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell2.setCellValue(logisticRecord.getOrderStatus());

                HSSFCell cell3 = row.createCell((short) 2);
                cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell3.setCellValue(logisticRecord.getCity());

                HSSFCell cell4 = row.createCell((short) 3);
                cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell4.setCellValue(logisticRecord.getOut_logistics_id());

                HSSFCell cell5 = row.createCell((short) 4);
                cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell5.setCellValue(logisticRecord.getPlantform_logistics_id());

                HSSFCell cell6 = row.createCell((short) 5);
                cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell6.setCellValue(logisticRecord.getDistance());

                HSSFCell cell7 = row.createCell((short) 6);
                cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell7.setCellValue(logisticRecord.getOrderStatus());

                HSSFCell cell8 = row.createCell((short) 7);
                cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell8.setCellValue(logisticRecord.getMoney());

                HSSFCell cell9 = row.createCell((short) 8);
                cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell9.setCellValue(logisticRecord.getOut_logistics_id_our());

                HSSFCell cell10 = row.createCell((short) 9);
                cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell10.setCellValue(logisticRecord.getPlantform_logistics_id_our());

            }

            FileOutputStream fOut = new FileOutputStream(outputFile);

            workbook.write(fOut);
            fOut.flush();
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }

}
