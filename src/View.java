import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {
    private JPanel ViewPanel;
    private JTextArea entryContent;
    private JButton addButton;
    private JComboBox<User> userSelector;
    private JButton saveToFileButton;
    private JComboBox entrySelector;

    public View(String title) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(500, 700));
        frame.setContentPane(this.getViewPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JComboBox<User> getUserSelector() {
        return userSelector;
    }

    public String getEntryContent() {
        return entryContent.getText();
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSaveToFileButton() {
        return saveToFileButton;
    }

    public JPanel getViewPanel() {
        return ViewPanel;
    }

    public void populateUserSelector(ArrayList<User> users) {
        for (User user : users) {
            userSelector.addItem(user);
        }
    }
}
