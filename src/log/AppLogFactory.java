package log;

import org.slf4j.LoggerFactory;

/**
 * 日志处理工具工厂类
 * 
 * @author jinma
 * @Date 2014年10月17日
 */
public class AppLogFactory {

    /**
     * <默认构造函数>
     */
    private AppLogFactory() {
    }

    /**
     * 获取Logger实例对象
     * 
     * @param clazz logger的class信息
     * @return AppLog 应用系统Logger实例对象
     */
    public static AppLog getLogger(Class<?> clazz) {
        return new AppLog(LoggerFactory.getLogger(clazz));
    }

    /**
     * 获取Logger实例对象
     * 
     * @param name logger的name信息
     * @return AppLog 应用系统Logger实例对象
     */
    public static AppLog getLogger(String name) {
        return new AppLog(LoggerFactory.getLogger(name));
    }

}
