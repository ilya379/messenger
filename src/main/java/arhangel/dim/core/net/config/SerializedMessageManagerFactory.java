package arhangel.dim.core.net.config;

import arhangel.dim.core.net.MessageManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by eaglesh on 29.04.16.
 */
@Component
public class SerializedMessageManagerFactory  extends  MessageManagerFactory {
    @Override
    public MessageManager createManager(Socket socket) throws IOException {
        MessageManager<ObjectInputStream, ObjectOutputStream> manager =
                new MessageManager<>(new ObjectInputStream(socket.getInputStream()), new ObjectOutputStream(socket.getOutputStream()));
        applicationContext.getAutowireCapableBeanFactory().autowireBean(manager);
        return manager;
    }
}
