package errorUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import log.AppLog;
import log.AppLogFactory;

import org.apache.commons.lang3.StringUtils;

import error.ErrorCodeInfo;
import errorException.ErrorCode;

/**
 * 错误码工具类
 * 
 */
public class ErrCodeUtil {

    private static final AppLog log     = AppLogFactory.getLogger(ErrCodeUtil.class);

    private static Pattern      pattern = Pattern.compile("[{](.)*?[}]");

    public static String getFormatErrMsg(ErrorCodeInfo errInfo) {
        return getFormatErrMsg(errInfo.getErrCode(), "", errInfo.getErrMsg());
    }

    /**
     * 获取错误码格式化消息
     * 
     * @param errCode 错误码
     * @param defaultErrorMsg 默认的错误消息，若配置文件中未配置则使用该值
     * @param debugErrMsg 用于debug的详细错误信息
     * @param args 动态参数数组，用于替换消息文本中的动态变量
     * @return String 格式化之后的消息内容
     */
//    public static String getFormatErrMsg(int errCode,String defaultErrorMsg, String debugErrMsg, Object[] args) {
//        // 获取客户端提示错误信息
//        String promptErrMsg = getPromptErrMsg(errCode, defaultErrorMsg, null);
//        
//        return getFormatErrMsg(errCode, promptErrMsg, debugErrMsg);
//    }

    /**
     * 获取错误码格式化消息
     * 
     * @param errCode 错误码
     * @param debugErrMsg 用于debug的详细错误信息
     * @return String 格式化之后的消息内容
     * @author jinma
     * @Date 2014年10月27日
     */
    public static String getFormatErrMsg(int errCode, String debugErrMsg) {
        // 获取客户端提示错误信息
        String promptErrMsg = getPromptErrMsg(errCode, "", null);

        return getFormatErrMsg(errCode, promptErrMsg, debugErrMsg);
    }

    /**
     * 获取错误码格式化消息
     * 
     * @param errCode 错误码
     * @param promptErrMsg 客户端提示错误信息
     * @param debugErrMsg 用于debug的详细错误信息
     * @return String 格式化之后的消息内容
     */
    public static String getFormatErrMsg(int errCode, String promptErrMsg, String debugErrMsg) {
        StringBuilder msg = new StringBuilder();
        msg.append("[").append(errCode).append("] - [");
        if (promptErrMsg != null) {
            msg.append(promptErrMsg);
        }
        msg.append("]");
        if (debugErrMsg != null) {
            msg.append(" : ").append(debugErrMsg);
        }
        return msg.toString();
    }

    /**
     * 根据错误码获取客户端用户提示信息
     * 
     * @param errCode 错误码
     * @param defaultErrorMsg 默认的错误消息，若配置文件中未配置则使用该值
     * @param args 用于替换的错误消息中的变量
     * @return String 客户端用户提示信息
     */
//    public static String getPromptErrMsg(int errCode, String defaultErrorMsg, Object[] args) {
//        String msgTemplate = ErrCodeProp.getInstance().getValue(errCode);
//        String finalMsg;
//        if(!StringUtils.isBlank(msgTemplate)){
//            finalMsg = msgTemplate;
//        }else if (!StringUtils.isBlank(defaultErrorMsg)){
//            finalMsg = defaultErrorMsg;
//        }else{
//            return ErrorCode.DEFAULT_SYS_ERROR_MSG;
//        }
//        if (args != null && args.length > 0) {
//            try {
//                
//                return format(finalMsg, args);
//            } catch (Exception e) {
//                log.error("failed to get property value.", e);
//                return ErrorCode.DEFAULT_SYS_ERROR_MSG;
//            }
//        }else{
//            return finalMsg;
//        }
//    }

    public static String getPromptErrMsg(int errCode, String defaultErrorMsg, Map<String, String> variables) {
        String msgTemplate = ErrCodeProp.getInstance().getValue(errCode);
        String finalMsg;
        if (!StringUtils.isBlank(msgTemplate)) {
            finalMsg = msgTemplate;
        } else if (!StringUtils.isBlank(defaultErrorMsg)) {
            finalMsg = defaultErrorMsg;
        } else {
            return ErrorCode.DEFAULT_SYS_ERROR_MSG;
        }

        if (variables != null && variables.size() > 0) {
            try {
                return templateProcess(finalMsg, variables);
            } catch (Exception e) {
                String msg = String.format("failed to process template msg for error code: %s, variables: %s", errCode,
                                           variables.toString());
                log.error(msg, e);
                return ErrorCode.DEFAULT_SYS_ERROR_MSG;
            }
        } else {
            return finalMsg;
        }
    }

    /**
     * 根据错误码获取客户端用户提示信息
     * 
     * @param errCode 错误码
     * @return String 客户端用户提示信息
     */
    public static String getPromptErrMsg(int errCode) {
        return getPromptErrMsg(errCode, "", null);
    }

    /**
     * 支持文本配置中的动态变量，如"aaa,{},bbb{},ccc"或者"aaa{code},aas{num}"
     * 
     * @param message
     * @param args
     * @return
     * @return String
     */
    private static String format(String message, Object[] args) {
        Matcher matcher = pattern.matcher(message);
        StringBuilder stringBuffer = new StringBuilder();
        int start = 0;
        int count = 0;
        while (matcher.find(start)) {
            if (count >= args.length) {
                String msg = String.format("实际传入参数个数(%s)少于配置文本的参数个数", args.length);
                throw new IllegalArgumentException(msg);
            }
            stringBuffer.append(message.substring(start, matcher.start()));
            stringBuffer.append(args[count++]);
            start = matcher.end();
        }
        if (count != args.length) {
            String msg = String.format("实际传入参数个数(%s)大于配置文本的参数个数(%s)", args.length, count);
            throw new IllegalArgumentException(msg);
        }
        stringBuffer.append(message.substring(start, message.length()));
        return stringBuffer.toString();
    }

    /**
     * 支持文本配置中的动态变量，如"输入长度超过{length},请重新输入"
     * 
     * @param template
     * @param variables
     * @return
     * @return String
     */
    private static String templateProcess(String template, Map<String, String> variables) {
        String msg = template;
        for (String key : variables.keySet()) {
            msg = msg.replace("{" + key + "}", variables.get(key).toString());
        }
        if (msg.contains("{") && msg.contains("}")) {
            String errorMsg = String.format("实际传入有效参数个数(<=%s) 小于配置文本的参数个数", variables.size());
            throw new IllegalArgumentException(errorMsg);
        }
        return msg;
    }

}
