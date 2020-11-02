import java.sql.Timestamp;
import java.util.ArrayList;

public class EntryManager {
    private ArrayList<Entry> entries;
    private ArrayList<User> users;

    public EntryManager() {
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void createEntry(String content, User author) {
        entries.add(new Entry(content, author));
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    public void createUser(String name, int id, String email, String password) {
        users.add(new User(name, id, email, password));
    }
}
