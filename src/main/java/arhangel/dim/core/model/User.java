package arhangel.dim.core.model;

import java.io.Serializable;

/**
 * Представление пользователя
 */
public class User implements Serializable{
    private Long id;
    private String name;
    private transient String login;
    private transient String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
		return "User{" +
				"id='" + id + '\'' +
				"name='" + name + '\'' +
				"login='" + login + '\'' +
				"password='" + password + '\'' +
			"}";
	}
}
