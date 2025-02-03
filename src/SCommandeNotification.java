public class SCommandeNotification {
    private static CommandeNotification instance = null;

    public SCommandeNotification() {}

    public static CommandeNotification getInstance() {
        if (instance == null) {
            instance = new CommandeNotification();
        }
        return instance;
    }
}
