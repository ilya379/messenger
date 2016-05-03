package arhangel.dim.core.net;

import arhangel.dim.core.messages.Message;
import arhangel.dim.core.net.protocol.Protocol;
import arhangel.dim.core.net.protocol.ProtocolException;
import arhangel.dim.lections.socket.IoUtil;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by eaglesh on 10.04.16.
 *
 * класс для взаимодействия с потоками ввода/вывода через протокол
 */
public class MessageManager<I extends InputStream, O extends OutputStream> {
    protected final I inputStream;
    protected final O outputStream;

    protected Protocol<I, O> protocol;

    public MessageManager(@NotNull I inputStream, @NotNull O outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }


    /**
     * Отправить сообщение получателю
     * @param message
     * @throws IOException
     * @throws ProtocolException
     */
    public void sendMessage(Message message) throws IOException, ProtocolException {
        protocol.encode(message, outputStream);
    }

    /**
     * блокировать поток, пока не будет получено новое сообщение
     * @return
     * @throws IOException
     * @throws ProtocolException
     */
    public Message getMessage() throws IOException, ProtocolException {
        return protocol.decode(inputStream);
    }

    @Autowired
    public void setProtocol(Protocol<I, O> protocol) {
        this.protocol = protocol;
    }

    /**
     * Молча (без проброса ошибок) закрываем соединение и освобождаем ресурсы
     */
    public void close() {
        IoUtil.closeQuietly(inputStream, outputStream);
    }
}
