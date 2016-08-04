package model;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月3日
 */
public class Result {

    /*
     * 原始订单好
     */
    private String plantform_logistics_id;
    /*
     * 订单编号
     */
    private String out_logistics_id;

    public String getPlantform_logistics_id() {
        return plantform_logistics_id;
    }

    public void setPlantform_logistics_id(String plantform_logistics_id) {
        this.plantform_logistics_id = plantform_logistics_id;
    }

    public String getOut_logistics_id() {
        return out_logistics_id;
    }

    public void setOut_logistics_id(String out_logistics_id) {
        this.out_logistics_id = out_logistics_id;
    }

    public String toString() {
        String result = "";
        result += "plantform_logistics_id= " + plantform_logistics_id + " out_logistics_id= " + out_logistics_id;
        return result;
    }
}
