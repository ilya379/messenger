package arhangel.dim.core.commands;

import org.springframework.stereotype.Component;

import arhangel.dim.core.messages.InfoMessage;
import arhangel.dim.core.messages.Message;
import arhangel.dim.core.messages.Type;
import arhangel.dim.core.net.Session;

/**
 * Created by eaglesh on 01.05.16.
 */
@Component
public class InfoCommand extends AbstractCommand<InfoMessage> {

	@Override
	public Type getSupportedType() {
		return Type.MSG_INFO;
	}

	@Override
	protected Message process(Session session, InfoMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean authorizedUserRequired() {
		return true;
	}
	
	
}
