package arhangel.dim.core.net.config;

import arhangel.dim.core.messages.Message;
import arhangel.dim.core.net.MessageManager;
import arhangel.dim.core.net.protocol.Protocol;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by eaglesh on 10.04.16.
 */
public abstract class MessageManagerFactory implements ApplicationContextAware {
    protected static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    public abstract MessageManager createManager(Socket socket) throws IOException;

}
