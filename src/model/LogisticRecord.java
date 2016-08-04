package model;

/**
 * 
 * @author 傅聪
 * @Date 2016年8月3日
 */
public class LogisticRecord {

    /*
     * 完成日期
     */
    private String finishTime;
    /*
     * 订单编号
     */
    private String out_logistics_id;
    /*
     * 订单状态
     */
    private String orderStatus;

    /*
     * 城市
     */
    private String city;

    /*
     * 商户编号
     */
    private String customeNum;
    /*
     * 订单金额
     */
    private String money;
    /*
     * 陪送距离
     */
    private String distance;
    /*
     * 运费金额
     */
    private String transportFee;
    /*
     * 配送范围
     */
    private String deliverScop;
    /*
     * 订单类型
     */
    private String orderType;
    /*
     * 原始订单号
     */
    private String plantform_logistics_id;

    /*
     * 物流单号
     */
    private String plantform_logistics_id_our;

    /*
     * 第三方订单号
     */
    private String out_logistics_id_our;

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getOut_logistics_id() {
        return out_logistics_id;
    }

    public void setOut_logistics_id(String out_logistics_id) {
        this.out_logistics_id = out_logistics_id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomeNum() {
        return customeNum;
    }

    public void setCustomeNum(String customeNum) {
        this.customeNum = customeNum;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(String transportFee) {
        this.transportFee = transportFee;
    }

    public String getDeliverScop() {
        return deliverScop;
    }

    public void setDeliverScop(String deliverScop) {
        this.deliverScop = deliverScop;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPlantform_logistics_id() {
        return plantform_logistics_id;
    }

    public void setPlantform_logistics_id(String plantform_logistics_id) {
        this.plantform_logistics_id = plantform_logistics_id;
    }

    public String toString() {
        String result = "";
        result += "finishTime＝ " + finishTime + " out_logistics_id=" + out_logistics_id + " orderStatus=" + orderStatus
                  + " city=" + city + " customeNum=" + customeNum + " money=" + money + " distance=" + distance
                  + " transportFee=" + transportFee + " deliverScop=" + deliverScop + " orderType=" + orderType
                  + " plantform_logistics_id=" + plantform_logistics_id;
        return result;
    }

    public String getPlantform_logistics_id_our() {
        return plantform_logistics_id_our;
    }

    public void setPlantform_logistics_id_our(String plantform_logistics_id_our) {
        this.plantform_logistics_id_our = plantform_logistics_id_our;
    }

    public String getOut_logistics_id_our() {
        return out_logistics_id_our;
    }

    public void setOut_logistics_id_our(String out_logistics_id_our) {
        this.out_logistics_id_our = out_logistics_id_our;
    }

}
