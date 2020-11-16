import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class EntryManager implements Serializable {
    private final ArrayList<Entry> entries;
    private final ArrayList<User> users;

    public EntryManager() {
        users = new ArrayList<>();
        entries = new ArrayList<>();
        createUser("default", 0, "default", "default");
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public Entry createEntry(String title, String content, User author) {
        Entry entry = new Entry(title, content, author);
        entries.add(entry);
        return entry;
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
