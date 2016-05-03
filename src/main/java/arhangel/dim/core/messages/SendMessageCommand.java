package arhangel.dim.core.messages;

import arhangel.dim.core.net.Session;

/**
 * Created by eaglesh on 01.05.16.
 */
public class SendMessageCommand implements Command {
    @Override
    public void execute(Session session, Message message) throws CommandException {
        if (!(message instanceof TextMessage)) {
            throw new CommandException(getClass().getSimpleName() + " не поддерживает обработку сообщения " + message.getType());
        }

        TextMessage textMessage = (TextMessage) message;


    }
}
