package arhangel.dim.lections.socket;

import java.io.Closeable;

/**
 *
 */
public class IoUtil {
    private IoUtil() {}

    public static void closeQuietly(Closeable res) {
        if (res != null) {
            try {
                res.close();
            } catch (Exception e) {
                // tsss!
            }
        }
    }

    public static void closeQuietly(Closeable... list) {
        for (Closeable res : list) {
            closeQuietly(res);
        }
    }
}
