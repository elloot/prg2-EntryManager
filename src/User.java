import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String name;
    private int id;
    private String email;
    private String password;

    public User(String name, int id, String email, String password) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + this.name;
    }
}
