package arhangel.dim.core.net.protocol;

import arhangel.dim.core.messages.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 */
@Component
public class BinaryProtocol implements Protocol<ObjectInputStream, ObjectOutputStream> {

    @Override
    public Message decode(ObjectInputStream inputStream) throws ProtocolException, IOException {
        try {
            return (Message) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new ProtocolException(e);
        }
    }

    @Override
    public void encode(Message msg, ObjectOutputStream outputStream) throws ProtocolException, IOException {
        outputStream.writeObject(msg);
    }
}
