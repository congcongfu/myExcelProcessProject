package errorException;

/**
 * 公共错误码，包括系统错误和常见业务错误
 * 
 */
public class CommonErrorCode extends DefaultErrorCode {

    /**
     * ==================================================================
     * 以下为公共系统错误码: 1~39，谨慎添加
     * ==================================================================
     */

    /**
     * 执行结果：系统错误，该通用错误码，未指名具体错误，一般是系统内部运行时出现问题或者代码bug
     */
    public static final ErrorCode SYS_ERROR                     = new CommonErrorCode(-1, "系统内部错误，请稍后再试",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 数据库执行错误
     */
    public static final ErrorCode SYS_DB_ERROR                  = new CommonErrorCode(-2, "数据库访问出错",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * IO操作错误
     */
    public static final ErrorCode SYS_IO_ERROR                  = new CommonErrorCode(-3, "文件IO读写出错",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 序列化错误
     */
    public static final ErrorCode SYS_SERIALIZE_ERROR           = new CommonErrorCode(-4, "序列化出错",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 日期格式化错误
     */
    public static final ErrorCode SYS_DATEFORMAT_ERROR          = new CommonErrorCode(-5, "日期格式化错误",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 文件上传错误
     */
    public static final ErrorCode SYS_FILEUPLOAD_ERROR          = new CommonErrorCode(-6, "文件上传错误",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * XML解析错误
     */
    public static final ErrorCode SYS_XML_PARSE_ERROR           = new CommonErrorCode(-7, "XML解析失败",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 加密或解密数据异常
     */
    public static final ErrorCode SYS_ENCRYPT_ERROR             = new CommonErrorCode(-8, "加密或解密数据异常",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * HTTP请求异常
     */
    public static final ErrorCode SYS_HTTP_REQUEST_ERROR        = new CommonErrorCode(-9, "HTTP请求异常",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 内部方法传入参数非法
     */
    public static final ErrorCode SYS_INTERNAL_ARGUMENT_INVALID = new CommonErrorCode(-10, "内部方法参数非法",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * ==================================================================
     * 以下为公共业务错误码: 40~59，谨慎添加
     * ==================================================================
     */

    /**
     * 输入域为空，业务验证
     */
    public static final ErrorCode BIZ_FIELD_EMPTY               = new CommonErrorCode(40, "{field_name}不能为空",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * 输入域长度不合法
     */
    public static final ErrorCode BIZ_FIELD_LENGTH_INVALID      = new CommonErrorCode(
                                                                                      41,
                                                                                      "{field_name}长度必须是{field_length_min}到{field_length_max}个字符之间",
                                                                                      MishiErrorDomain.COMMON);
    /**
     * 输入域长度超过XX字符
     */
    public static final ErrorCode BIZ_FIELD_LENGTH_TOO_MAX      = new CommonErrorCode(
                                                                                      41,
                                                                                      "{field_name}长度不能超过{field_length_max}个字符",
                                                                                      MishiErrorDomain.COMMON);

    /**
     * ===================================================================
     * 安全错误码: 71~79，谨慎添加
     * ===================================================================
     */

    /**
     * 越权操作
     */
    public static final ErrorCode SEC_NO_PERMISSION             = new CommonErrorCode(71, "无权限操作",
                                                                                      MishiErrorDomain.COMMON);

    CommonErrorCode(int code, String message, ErrorDomain errorDomain) {
        super(code, message, errorDomain);
    }

}
