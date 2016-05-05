package arhangel.dim.core.commands;

/**
 *
 */
public class CommandException extends Exception {
    public CommandException(String msg) {
        super(msg);
    }

    public CommandException(Throwable ex) {
        super(ex);
    }

	public CommandException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
    
    
}
