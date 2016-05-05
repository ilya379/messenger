package arhangel.dim.core.messages;


/**
 * Запрос информации о пользователе
 */
public class InfoMessage extends Message {
	private static final long serialVersionUID = 8347482711869267708L;

	public InfoMessage() {
        type = Type.MSG_INFO;
    }

    @Override
    public String toString() {
        return "InfoMessage{" +
                "id='" + id + '\'' +
                '}';
    }
}
