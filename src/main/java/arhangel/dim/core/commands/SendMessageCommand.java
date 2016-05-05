package arhangel.dim.core.commands;

import org.springframework.stereotype.Component;

import arhangel.dim.core.messages.Message;
import arhangel.dim.core.messages.StatusMessage;
import arhangel.dim.core.messages.TextMessage;
import arhangel.dim.core.messages.Type;
import arhangel.dim.core.model.Chat;
import arhangel.dim.core.net.Session;

/**
 * Created by eaglesh on 01.05.16.
 */
@Component
public class SendMessageCommand extends AbstractCommand<TextMessage> {   

	@Override
	public Type getSupportedType() {
		return Type.MSG_TEXT;
	}

	@Override
	protected Message process(Session session, TextMessage message) {
        Chat chat = messageStore.getChatById(message.getId());
        if (chat != null) {
        	messageStore.addMessage(chat.getId(), message);
        	return new StatusMessage();
        } else {
        	return new StatusMessage("Вы не принадлежите данному чату");
        }		
	}

	@Override
	protected boolean authorizedUserRequired() {
		return true;
	}

}
