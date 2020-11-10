import javax.swing.*;

public class Controller {
    private EntryManager entryManager;
    private View view;

    public Controller(EntryManager em, View v) {
        entryManager = em;
        view = v;
        addAddListener();
        view.populateComboBox(entryManager.getUsers());
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
