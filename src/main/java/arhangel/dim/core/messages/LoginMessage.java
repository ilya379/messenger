package arhangel.dim.core.messages;


/**
 * Сообщение авторизации
 */
public class LoginMessage extends Message {
	private static final long serialVersionUID = -2479821298463227465L;
	private String login;
    private String password;

    public LoginMessage() {
        type = Type.MSG_LOGIN;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return "LoginMessage{" +
                "login='" + login + '\'' +
                '}';
    }
}
