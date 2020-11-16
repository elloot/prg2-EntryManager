import java.io.*;

public class FileIO {
    String fileName;

    public FileIO(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {

    }

    public void writeEntryManagerToFile(EntryManager entryManager) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = null;

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(this.fileName)));
            out.writeObject(entryManager);
        } finally {
            out.close();
        }
    }

    public EntryManager readEntryManagerFile() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        EntryManager entryManager;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.fileName)));
            entryManager = (EntryManager) in.readObject();
        } finally {
            in.close();
        }

        return entryManager;
    }
}