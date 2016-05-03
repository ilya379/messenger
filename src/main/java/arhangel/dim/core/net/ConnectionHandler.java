package arhangel.dim.core.net;

import arhangel.dim.core.messages.Message;

/**
 * Описывает поведение слушателя сокета
 *
 */
public interface ConnectionHandler {

    /**
     * Реакция на сообщение, пришедшее из сети
     */
    void onMessage(Message msg);

}
