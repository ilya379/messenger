package arhangel.dim.core.net.config;

import arhangel.dim.core.net.protocol.Protocol;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by eaglesh on 10.04.16.
 */
public class NetworkConfigurationHolder {
    /**
     * Протокол, хост и порт инициализируются из конфига
     *
     * */
    private Protocol protocol;
    private int port = 19000;
    private String host = "localhost";

    public Protocol getProtocol() {
        return protocol;
    }

    @Autowired
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
