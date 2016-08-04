package process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月3日
 */
public class ExcelReader {

    public static String outputFile = "/Users/mishi/result.xls";

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/mishi/sqlResult_712259.csv"));// 换成你的文件名
            reader.readLine();// 第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");// CSV格式文件为逗号分隔符文件，这里根据逗号切分

                String last = item[item.length - 1];// 这就是你要的数据了
                String plantform_logistics_id = item[1];
                plantform_logistics_id = plantform_logistics_id.substring(1, plantform_logistics_id.length() - 1);
                String out_logistics_id = item[2];
                out_logistics_id = out_logistics_id.substring(1, out_logistics_id.length() - 1);
                // int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                System.out.println(" plantform_logistics_id= " + plantform_logistics_id + " out_logistics_id= "
                                   + out_logistics_id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
