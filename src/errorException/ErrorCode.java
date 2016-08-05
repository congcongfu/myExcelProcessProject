package errorException;

/**
 * 错误码接口，异常处理模块直接依赖,错误码目前是整数，负数表示系统错误，错误消息文本允许动态变量，具体用法见{@link AppRuntimeException#set(String key, Object val)}
 * 
 */
public interface ErrorCode {

    /**
     * 错误码，负数表示是系统内部错误
     * 
     * @return 错误码
     * @return int
     */
    int getCode();

    /**
     * 错误消息文本，允许动态变量，具体用法见{@link AppRuntimeException#set(String key, Object val)}
     * 
     * @return 错误消息文本
     * @return String
     */
    String getMessage();

    /**
     * 错误所在业务域
     * 
     * @return
     * @return String
     */
    String getDomain();

    /**
     * 错误码声明所在的类，用于日志输出，方便定位
     * 
     * @return
     * @return String
     */
    String getLocation();

    /**
     * 错误最终被日志记录的级别
     * 
     * @return
     * @return ErrorLogLevel
     */
    ErrorLogLevel getLogLevel();

    /*
     * ======================================
     * 以下是静态常量
     * =====================================
     */
    /**
     * 错误码为0表示成功，比较特殊，不纳入错误码体系
     */
    static final int    SYS_SUCCESS           = 0;
    static final int    SYS_IO_ERROR          = 1;

    /**
     * 默认系统错误消息
     */
    static final String DEFAULT_SYS_ERROR_MSG = "系统内部错误，请稍后再试";

}
