import java.sql.Timestamp;

public class Edit {
    private String content;
    private Timestamp createdAt;
    private User author;

    public Edit(String content, User author) {
        this.content = content;
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public Timestamp getCreationDate() {
        return createdAt;
    }

    public User getAuthor() {
        return author;
    }
}
