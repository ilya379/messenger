package arhangel.dim.core.commands;

import org.springframework.stereotype.Component;

import arhangel.dim.core.messages.LoginMessage;
import arhangel.dim.core.messages.Message;
import arhangel.dim.core.messages.StatusMessage;
import arhangel.dim.core.messages.Type;
import arhangel.dim.core.model.User;
import arhangel.dim.core.net.Session;

/**
 * Created by eaglesh on 01.05.16.
 */
@Component
public class LoginCommand extends AbstractCommand<LoginMessage> {

	@Override
	public Type getSupportedType() {
		return Type.MSG_LOGIN;
	}

	@Override
	protected Message process(Session session, LoginMessage message) {
        String login = message.getLogin();
        String pass = message.getPassword();
        User user = userStore.getUser(login, pass);
        if (user != null) {
        	user.setLogin(login);
        	user.setPassword(pass);
        	session.setUser(user);
        	return new StatusMessage();
        } else {
        	return new StatusMessage("Не удалось авторизоваться");		
        }
	}

	@Override
	protected boolean authorizedUserRequired() {
		return false;
	}
}
