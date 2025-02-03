public class SListeProduit {
    private static ListeProduit instance = null;

    public static ListeProduit getInstance() {
        if (instance == null) {
            instance = new ListeProduit();
        }
        return instance;
    }
}
