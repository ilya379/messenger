package arhangel.dim.core.net;

import arhangel.dim.core.User;
import arhangel.dim.core.messages.CommandException;
import arhangel.dim.core.messages.CommandRepository;
import arhangel.dim.core.messages.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Здесь храним всю информацию, связанную с отдельным клиентом.
 * - объект User - описание пользователя
 * - сокеты на чтение/запись данных в канал пользователя
 */
public class Session implements ConnectionHandler {
    private Logger logger;
    private static AtomicLong counter = new AtomicLong(1);

    /**
     * id сессии (для логгирования)
     */
    private Long id;

    public Session() {
        id = counter.getAndIncrement();
        logger  = LoggerFactory.getLogger("Session-" + id);
    }

    /**
     * Пользователь сессии, пока не прошел логин, user == null
     * После логина устанавливается реальный пользователь
     */
    private User user;

    private MessageManager manager;

    private boolean closed = false;

    public Session(MessageManager manager) {
        this.manager = manager;
    }


    @Override
    public void onMessage(Message msg) {
        try {
            CommandRepository.getCommand(msg.getType()).execute(this, msg);
        } catch (CommandException e) {
            logger.error("Ошибка при выполнении команды "+ msg.getType(), e);
        }
    }

    public void send(Message msg) {
        try {
            manager.sendMessage(msg);
        } catch (Exception e) {
            closed = true;
            close();
            throw new SessionClosedException(e);
        }
    }

    public boolean isClosed() {
        return closed;
    }

    public void close() {
        closed = true;
        manager.close();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
