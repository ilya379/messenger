package arhangel.dim.core.messages;

import arhangel.dim.core.model.User;


/**
 * Информация о пользователе
 */
public class InfoResultMessage extends Message {
	private static final long serialVersionUID = -1900340352281872789L;
	private User user;
	private String text;

    public InfoResultMessage() {
        type = Type.MSG_INFO_RESULT;
    }
    
    public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}
    public String getText() {
		return text;
	}
    public void setText(String text) {
		this.text = text;
	}

    @Override
    public String toString() {
        return "InfoResultMessage{" +
                "text='" + text + '\'' +
                "user='" + user + '\'' +
                '}';
    }
}
