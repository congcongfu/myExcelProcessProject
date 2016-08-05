package errorUtil;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import log.AppLog;
import log.AppLogFactory;
import stream.StreamUtils;
import errorException.ErrorCode;

/**
 * 错误码属性配置文件加载工具类
 * 
 */
public class ErrCodeProp {

    private static final AppLog log                  = AppLogFactory.getLogger(ErrCodeProp.class);

    private static final String ERROR_CODE_FILE_PATH = "/error_code.properties";

    private static Properties   prop                 = new Properties();

    private static class SingletonImpl {

        private static final ErrCodeProp instance = new ErrCodeProp();
    }

    /**
     * <默认构造函数>
     */
    private ErrCodeProp() {
        init();
    }

    public static ErrCodeProp getInstance() {
        return SingletonImpl.instance;
    }

    private void init() {
        log.info("[init] start init error code properties ... ...");
        reload();
    }

    public void reload() {
        log.info("start loading error code properties ... ...");
        InputStream inStream = null;
        try {
            if (log.isInfoEnabled()) {
                URL url = ErrCodeProp.class.getResource(ERROR_CODE_FILE_PATH);
                log.info(url == null ? "url [" + ERROR_CODE_FILE_PATH + "] is null." : url.toString());
            }
            inStream = ErrCodeProp.class.getResourceAsStream(ERROR_CODE_FILE_PATH);
            prop.load(inStream);
            log.info("loading error code properties success.");
        } catch (IOException e) {
            log.error(ErrorCode.SYS_IO_ERROR, "加载错误码属性配置文件异常。", e);
        } finally {
            StreamUtils.closeStream(inStream);
        }
    }

    public String getValue(int errCode) {
        return getValue(String.valueOf(errCode), null);
    }

    public String getValue(int errCode, String defaultValue) {
        return getValue(String.valueOf(errCode), defaultValue);
    }

    public String getValue(String key) {
        return prop.getProperty(key);
    }

    public String getValue(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }

    public static void main(String[] args) {
        String value = ErrCodeProp.getInstance().getValue("-1");
        System.out.println(value);
        String value2 = ErrCodeProp.getInstance().getValue(0);
        System.out.println(value2);
    }

}
