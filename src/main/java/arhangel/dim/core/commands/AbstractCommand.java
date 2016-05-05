package arhangel.dim.core.commands;

import org.springframework.beans.factory.annotation.Autowired;

import arhangel.dim.core.messages.Message;
import arhangel.dim.core.messages.StatusMessage;
import arhangel.dim.core.net.Session;
import arhangel.dim.core.store.MessageStore;
import arhangel.dim.core.store.UserStore;

public abstract class AbstractCommand<T extends Message> implements Command{
	protected UserStore userStore;
	protected MessageStore messageStore;

	@Override
	public void execute(Session session, Message message) throws CommandException {
		T specMessage = null;
		try {
			specMessage = (T) message;
		} catch (ClassCastException e) {
			throw new CommandException(getClass().getSimpleName() + " не поддерживает обработку сообщения " + message.getType(), e);
		}
		if (authorizedUserRequired() && session.getUser() == null) {
			session.send(new StatusMessage("Не авторизован"));
		}
		Message result = process(session, specMessage);
		if (result != null)
			session.send(result);
	}
	
	protected abstract Message process(Session session, T message);
	protected abstract boolean authorizedUserRequired();
	
	@Autowired
	public void setUserStore(UserStore userStore) {
		this.userStore = userStore;
	}
	
	@Autowired
	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}
	

}
