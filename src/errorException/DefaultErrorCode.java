package errorException;

/**
 * 默认ErrorCode实现,具体业务域的错误码声明继承该类，参考{@link CommonErrorCode} <br/>
 * 注意错误码正数表示业务异常，负数表示系统异常，所有的范围约束和唯一性约束都是针对绝对值，不能出现绝对值相等的两个正负错误码，比如 1 和 -1，可以把正负理解成一种boolean的标记位而已
 * 
 * @see CommonErrorCode
 */
public class DefaultErrorCode implements ErrorCode {

    /**
     * 错误码
     */
    private int           code;
    /**
     * 错误消息文本
     */
    protected String      message;
    /**
     * 错误所属的业务域
     */
    private ErrorDomain   errorDomain;

    /**
     * 错误码对应的日志级别，系统错误码永远是error，业务错误可以根据需要显式提升级别
     */
    private ErrorLogLevel logLevel = ErrorLogLevel.ERROR;

    protected DefaultErrorCode(int code, String message, ErrorDomain errorDomain) {
        this.code = code;
        this.message = message;
        this.errorDomain = errorDomain;
        validateCode(code);
        initLevel();
    }

    /**
     * 验证错误码合法性，错误码的绝对值不能超过声明的错误域范围
     * 
     * @param code
     * @return void
     * @author 叶正卿
     */
    protected void validateCode(int code) {
        if (!errorDomain.getCodeRange().contains(Math.abs(code))) {
            throw new IllegalArgumentException("code (" + code + ") is not valid as the valid range is "
                                               + errorDomain.getCodeRange().toString());
        }
    }

    /**
     * 验证错误日志级别合法性，系统错误必须是error
     * 
     * @param level
     * @return void
     * @author 叶正卿
     */
    protected void initLevel() {
        if (isSystemError()) {
            logLevel = ErrorLogLevel.ERROR;
        } else {
            logLevel = ErrorLogLevel.INFO;
        }
    }

    public String getDomain() {
        return errorDomain.getDomain();
    }

    public ErrorLogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * 升级业务错误码的日志级别到warning,用于个别希望提高该业务错误线上感知能力的场景
     * 
     * @return
     * @return ErrorCode
     * @author 叶正卿
     */
    protected ErrorCode toWarning() {
        if (!isSystemError()) {
            logLevel = ErrorLogLevel.WARNING;
        }
        return this;
    }

    /**
     * 升级业务错误码的日志级别到error,用于个别希望提高该业务错误线上感知能力的场景
     * 
     * @return
     * @return ErrorCode
     * @author 叶正卿
     */
    protected ErrorCode toError() {
        if (!isSystemError()) {
            logLevel = ErrorLogLevel.ERROR;
        }
        return this;
    }

    /**
     * 是否是系统错误，目前规则是负数为系统错误，关于系统错误的定义见{@link com.mishi.common.exception.SystemException}
     * 
     * @return
     * @return boolean
     * @author 叶正卿
     */
    private boolean isSystemError() {
        return code < 0;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getLocation() {
        return getClass().getName();
    }
}
