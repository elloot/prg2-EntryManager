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
        view.populateUserSelector(entryManager.getUsers());
        view.populateEntrySelector(getUserEntries(getSelectedUser().getId()));
    }

    public Controller(View v, FileIO f) {
        view = v;
        fileIO = f;
        entryManager = readEntryManagerFile();
        addAddListener();
        view.populateUserSelector(entryManager.getUsers());
        view.populateEntrySelector(getUserEntries(getSelectedUser().getId()));
    }

    private Entry getUserEntry(int userID, int index) {
        ArrayList<Entry> entries = getUserEntries(userID);
        return entries.get(index);
    }

    public ArrayList<Entry> getUserEntries(int userID) {
        ArrayList<Entry> entries = entryManager.getEntries();
        ArrayList<Entry> userEntries = new ArrayList<>();
        for (Entry currentEntry : entries) {
            if (currentEntry.getAuthor().getId() == userID) {
                userEntries.add(currentEntry);
            }
        }

        return userEntries;
    }

    public void writeEntryManagerToFile() {
        try {
            fileIO.writeEntryManagerToFile(entryManager, fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void addSaveToFileListener() {
        view.getSaveToFileButton().addActionListener(e -> {
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

    private User getSelectedUser() {
        JComboBox<User> userSelector = view.getUserSelector();
        return (User) userSelector.getSelectedItem();
    }

    private void addAddListener() {
        view.getAddButton().addActionListener(e -> {
            User author = getSelectedUser();
            System.out.println(addEntry(view.getEntryTitle(), view.getEntryContent(), author));
        });
    }

    private Entry addEntry(String title, String content, User author) {
        return entryManager.createEntry(title, content, author);
    }
}
