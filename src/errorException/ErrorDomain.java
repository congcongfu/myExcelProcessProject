package errorException;

import com.google.common.collect.Range;

/**
 * 错误域定义接口，区分错误码所在业务域，实现参考{@link MishiErrorDomain}，因为枚举不支持继承，建议直接拷贝MishiErrorDomain代码。
 * 
 */
public interface ErrorDomain {

    /**
     * 获取错误域
     * 
     * @return 错误域，风格类似java package，如mishi.fund等
     * @return String
     */
    String getDomain();

    /**
     * 获取错误域对应错误码范围，用于错误码验证和整体规划
     * 
     * @return
     * @return Range<Integer>
     */
    Range<Integer> getCodeRange();

    /**
     * 遗留于{@link com.mishi.common.error.constants.ErrorCode}中的错误码默认的错误域
     */
    static final String LEGACY_DOMAIN_NAME = "mishi.legacy";
}
