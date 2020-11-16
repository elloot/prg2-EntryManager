public class Main {
    public static void main(String[] args) {
        EntryManager entryManager = new EntryManager();
        View view = new View("EntryManager");
        FileIO fileIO = new FileIO("EntryManager.obj");
        Controller controller = new Controller(entryManager, view, fileIO);

        controller.writeEntryManagerToFile();
    }
}
