package arhangel.dim.core.store;

import arhangel.dim.core.model.User;

/**
 * Хранилище информации о пользователе
 */
public interface UserStore {

    /**
     * Добавить пользователя в хранилище
     * Вернуть его же
     * Вернуть null если пользователь с таким login уже существует
     */
    User addUser(User user);

    /**
     * Обновить информацию о пользователе
     */
    User updateUser(User user);

    /**
     *
     * Получить пользователя по логину/паролю
     * return null if user not found
     */
    User getUser(String login, String pass);

    /**
     *
     * Получить пользователя по id, например запрос информации/профиля
     * return null if user not found
     */
    User getUserById(Long id);
}
