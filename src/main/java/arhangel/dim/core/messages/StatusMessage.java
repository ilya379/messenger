package arhangel.dim.core.messages;


/**
 * Простое текстовое сообщение (статус)
 */
public class StatusMessage extends Message {
	private static final long serialVersionUID = -6717633002343111375L;
	private String text;
    private Boolean success;

    /**
     * Дефолтный статус OK
     */
    public StatusMessage() {
        type = Type.MSG_STATUS;
        success = true;
    }
    
    /**
     * Дефолтный статус FAIL
     * @param msg
     */
    public StatusMessage(String msg) {
        type = Type.MSG_STATUS;
        text = msg;
        success = false;
    }  
    public String getText() {
		return text;
	}
    public void setText(String text) {
		this.text = text;
	}
    public Boolean isSuccess() {
		return success;
	}
    public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
    public String toString() {
        return "StatusMessage{" + (success ? "success" : text) +'}';
    }
}
