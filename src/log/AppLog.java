package log;

import org.slf4j.Logger;

import error.ErrorCodeInfo;
import errorException.ErrorCode;
import errorUtil.ErrCodeUtil;

/**
 * 日志处理工具类
 * 
 */
public class AppLog {

    private Logger log;

    /**
     * <默认构造函数>
     * 
     * @param log Logger实例对象
     */
    public AppLog(Logger log) {
        super();
        this.log = log;
    }

    public String getName() {
        return log.getName();
    }

    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    public void debug(String msg) {
        log.debug(msg);
    }

    public void debug(String msg, Throwable t) {
        log.debug(msg, t);
    }

    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void info(String msg, Throwable t) {
        log.info(msg, t);
    }

    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    public void warn(String msg) {
        log.warn(msg);
    }

    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
    }

    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }

    public void error(String msg) {
        log.error(msg);
    }

    public void error(String msg, Throwable t) {
        log.error(msg, t);
    }

    /*
     * 以下根据错误码对象打印格式化的日志
     * ---------------------------------------------------------------
     */
    public void debug(ErrorCodeInfo errInfo) {
        if (errInfo == null) {
            return;
        }
        if (isDebugEnabled()) {
            debug(ErrCodeUtil.getFormatErrMsg(errInfo));
        }
    }

    public void debug(ErrorCode errCode, String msg) {
        if (isDebugEnabled()) {
            debug(ErrCodeUtil.getFormatErrMsg(errCode.getCode(), msg));
        }
    }

    public void debug(int errCode, String msg) {
        if (isDebugEnabled()) {
            debug(ErrCodeUtil.getFormatErrMsg(errCode, msg));
        }
    }

    public void debug(int errCode, String msg, Throwable t) {
        if (isDebugEnabled()) {
            debug(ErrCodeUtil.getFormatErrMsg(errCode, msg), t);
        }
    }

    public void info(ErrorCode errCode, String msg) {
        if (isInfoEnabled()) {
            info(ErrCodeUtil.getFormatErrMsg(errCode.getCode(), msg));
        }
    }

    public void info(int errCode, String msg) {
        if (isInfoEnabled()) {
            info(ErrCodeUtil.getFormatErrMsg(errCode, msg));
        }
    }

    public void info(int errCode, String msg, Throwable t) {
        if (isInfoEnabled()) {
            info(ErrCodeUtil.getFormatErrMsg(errCode, msg), t);
        }
    }

    public void warn(int errCode, String msg) {
        if (isWarnEnabled()) {
            warn(ErrCodeUtil.getFormatErrMsg(errCode, msg));
        }
    }

    public void warn(ErrorCode errCode, String msg) {
        if (isWarnEnabled()) {
            warn(ErrCodeUtil.getFormatErrMsg(errCode.getCode(), msg));
        }
    }

    public void warn(int errCode, String msg, Throwable t) {
        if (isWarnEnabled()) {
            warn(ErrCodeUtil.getFormatErrMsg(errCode, msg), t);
        }
    }

    public void error(int errCode, String msg) {
        error(ErrCodeUtil.getFormatErrMsg(errCode, msg));
    }

    public void error(int errCode, String msg, Throwable t) {
        error(ErrCodeUtil.getFormatErrMsg(errCode, msg), t);
    }

    public void error(ErrorCode errCode, String msg, Throwable t) {
        error(ErrCodeUtil.getFormatErrMsg(errCode.getCode(), msg), t);
    }

}
