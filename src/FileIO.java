import java.io.*;

public class FileIO {
    public void writeEntryManagerToFile(EntryManager entryManager, String fileName) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeObject(entryManager);
        } finally {
            out.close();
        }
    }

    public EntryManager readEntryManagerFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        EntryManager entryManager;

        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            entryManager = (EntryManager) in.readObject();
        } finally {
            in.close();
        }

        return entryManager;
    }
}