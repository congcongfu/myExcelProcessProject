package stream;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

import log.AppLog;
import log.AppLogFactory;
import errorException.ErrorCode;

/**
 * IO流工具类
 * 
 */
public class StreamUtils {

    private static final AppLog log = AppLogFactory.getLogger(StreamUtils.class);

    public static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error(ErrorCode.SYS_IO_ERROR, "关闭IO流异常。", e);
            }
        }
    }

    public static void closeStream(OutputStream stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                log.error(ErrorCode.SYS_IO_ERROR, "关闭IO流异常。", e);
            }
        }
    }

}
