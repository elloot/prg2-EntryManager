import java.sql.Timestamp;
import java.util.ArrayList;

public class Entry {
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private User author;
    private ArrayList<Edit> edits;

    public Entry(String content, User author) {
        this.content = content;
        this.author = author;
    }

    public void edit(String content, User author) {

    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreationDate() {
        return createdAt;
    }

    public Timestamp getEditDate() {
        return updatedAt;
    }

    public User getAuthor() {
        return author;
    }

    public ArrayList<Edit> getEdits() {
        return edits;
    }
}
