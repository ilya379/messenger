package arhangel.dim.core.messages;

/**
 * Простое текстовое сообщение
 */
public class TextMessage extends Message {
	private static final long serialVersionUID = 2241967047096164145L;
	private String text;

    public TextMessage() {
        type = Type.MSG_TEXT;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}
