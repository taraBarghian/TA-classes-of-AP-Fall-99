import java.io.Serializable;

public class User implements Serializable {
    String username;
    String Email;
    transient String password;

    public User(String username, String email, String password) {
        this.username = username;
        Email = email;
        this.password = password;
    }
}
