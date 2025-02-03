public class STransactionLogger {
    private static TransactionLogger instance = null;

    public STransactionLogger() {}

    public static TransactionLogger getInstance() {
        if (instance != null) {
            instance = new TransactionLogger();
        }
        return instance;
    }
}
