package error;

/**
 * 错误码消息JavaBean实例对象。
 * 
 *
 */
public class ErrorCodeInfo {

    /**
     * 错误码
     */
    private int    errCode;

    /**
     * 错误
     */
    private String errMsg;

    public ErrorCodeInfo() {
    }

    public ErrorCodeInfo(int errCode) {
        this.errCode = errCode;
    }

    public ErrorCodeInfo(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * @return the errCode
     */
    public int getErrCode() {
        return errCode;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param errMsg the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
