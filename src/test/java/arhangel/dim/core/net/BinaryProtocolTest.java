package arhangel.dim.core.net;

import arhangel.dim.core.net.protocol.Protocol;
import arhangel.dim.core.net.protocol.StringProtocol;
import org.junit.Assert;
import org.junit.Test;

import arhangel.dim.core.messages.Message;
import arhangel.dim.core.messages.TextMessage;
import arhangel.dim.core.messages.Type;

/**
 *
 */
public class BinaryProtocolTest {

    @Test
    public void decode() throws Exception {
        StringProtocol protocol = new StringProtocol();
        TextMessage message = new TextMessage();
        message.setText("Hello");
        message.setSenderId(1L);
        message.setType(Type.MSG_TEXT);

        byte[] data = protocol.encode(message);
        Assert.assertTrue(data != null);

        Message other = protocol.decode(data);
        Assert.assertEquals(message, other);

    }
}