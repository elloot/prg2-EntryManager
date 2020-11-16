import javax.swing.*;
import java.io.IOException;

public class Controller {
    private EntryManager entryManager;
    private View view;
    private FileIO fileIO;

    public Controller(EntryManager em, View v, FileIO f) {
        entryManager = em;
        view = v;
        fileIO = f;
        addAddListener();
        view.populateComboBox(entryManager.getUsers());
    }

    public void writeEntryManagerToFile() {
        try {
            fileIO.writeEntryManagerToFile(entryManager);
            fileIO.readEntryManagerFile();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addAddListener() {
        view.getAddButton().addActionListener(e -> {
            JComboBox<User> box = view.getUserSelector();
            User author = (User) box.getSelectedItem();
            System.out.println(addEntry(view.getEntryContent(), author));
        });
    }

    private Entry addEntry(String content, User author) {
        return entryManager.createEntry(content, author);
    }
}
