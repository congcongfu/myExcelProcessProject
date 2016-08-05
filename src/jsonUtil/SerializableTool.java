package jsonUtil;

import log.AppLog;
import log.AppLogFactory;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 序列化工具
 * 
 * @author
 */
public class SerializableTool {

    protected static final AppLog log = AppLogFactory.getLogger(SerializableTool.class);

    private SerializableTool() {
    }

    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     */
    public static <T> String serialize(T object) {
        if (object == null) {
            return null;
        }
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            log.warn("serialize failed. \n" + object.toString());
            throw e;
        }
    }

    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     */
    public static <T> String serializeFormat(T object) {
        return serialize(object, SerializerFeature.PrettyFormat);
    }

    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     */
    public static <T> String serializeDateFormat(T object) {
        return serialize(object, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     */
    public static <T> String serializeDateAndPrettyFormat(T object) {
        return serialize(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 序列化
     * 
     * @param object 待序列化的实例对象
     * @return 序列化的JSON字符串
     */
    private static <T> String serialize(T object, SerializerFeature... features) {
        if (object == null) {
            return null;
        }
        try {
            return JSON.toJSONString(object, features);
        } catch (Exception e) {
            log.warn("serialize failed. \n" + object.toString());
            throw e;
        }
    }

    /**
     * 反序列化
     * 
     * @param jsonString 待反序列的json字符串
     * @param clazz 反序列化的目标对象的class
     * @return 目标实例对象
     */
    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            return JSON.parseObject(jsonString, clazz);
        } catch (Exception e) {
            log.warn("parseObject failed. \n" + jsonString);
            throw e;
        }
    }

    /**
     * 
     * 方法parse的功能描述：反序列化
     * 
     * @param jsonString 待反序列的json字符串
     * @return
     * @return Object 目标实例对象
     * @since v3.1.2
     * 
     * <PRE>
     * author hongwei.chen@mishi.com 
     * Date 2016年3月2日
     * </PRE>
     */
    public static Object parse(String jsonString) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            return JSON.parse(jsonString);
        } catch (Exception e) {
            log.warn("parseObject failed. \n" + jsonString);
            throw e;
        }
    }

    /**
     * 反序列化
     * 
     * @param jsonString 待反序列的json字符串
     * @param clazz 反序列化的目标对象的class
     * @return 目标实例对象
     */
    public static Object deserialize(String jsonString, Class<?> clazz) {
        if (StringUtils.isBlank(jsonString)) {
            return null;
        }
        try {
            if (StringUtils.startsWith(jsonString, "[")) {
                return JSON.parseArray(jsonString, clazz);
            } else {
                return JSON.parseObject(jsonString, clazz);
            }
        } catch (Exception e) {
            log.warn("parseObject failed. \n" + jsonString);
            throw e;
        }
    }
}
