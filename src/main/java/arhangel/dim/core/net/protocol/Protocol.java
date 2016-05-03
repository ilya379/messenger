package arhangel.dim.core.net.protocol;

import arhangel.dim.core.messages.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 */
public interface Protocol<I extends InputStream, O extends  OutputStream> {

    Message decode(I inputStream) throws ProtocolException, IOException;

    void encode(Message msg, O outputStream) throws ProtocolException, IOException;

}
