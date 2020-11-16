import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private final EntryManager entryManager;
    private final View view;
    private final FileIO fileIO;
    private final String fileName = "entrymanager.obj";

    public Controller(EntryManager em, View v, FileIO f) {
        view = v;
        fileIO = f;
        entryManager = em;
        addAddListener();
        addSaveToFileListener();
        view.populateComboBox(entryManager.getUsers());
    }

    public Controller(View v, FileIO f) {
        view = v;
        fileIO = f;
        entryManager = readEntryManagerFile();
        addAddListener();
        view.populateComboBox(entryManager.getUsers());
    }

    public void writeEntryManagerToFile() {
        try {
            fileIO.writeEntryManagerToFile(entryManager, fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addSaveToFileListener() {
        view.getAddButton().addActionListener(e -> {
            writeEntryManagerToFile();
        });
    }

    public EntryManager readEntryManagerFile() {
        EntryManager entryManager = null;
        try {
            entryManager = fileIO.readEntryManagerFile(fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return entryManager;
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
