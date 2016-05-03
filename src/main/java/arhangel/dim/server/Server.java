package arhangel.dim.server;

import arhangel.dim.core.net.protocol.Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Основной класс для сервера сообщений
 */
public class Server {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final int DEFAULT_MAX_CONNECT = 16;

    // Засетить из конфига
    private int port;
    private Protocol protocol;
    private int maxConnection = DEFAULT_MAX_CONNECT;

    public void stop() {
        // TODO: закрыть все сетевые подключения, остановить потоки-обработчики, закрыть ресурсы, если есть.
    }

    public void start() {
        logger.info("Start server on port " + port);

    }

}
