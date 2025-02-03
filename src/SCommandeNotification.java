public class SCommandeNotification {
    private static CommandeNotification instance = null;

    private SCommandeNotification() {}

    public static CommandeNotification getInstance() {
        if (instance == null) {
            instance = new CommandeNotification();
        }
        return instance;
    }
}
