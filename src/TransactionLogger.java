import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLogger {
    private List<String> logs = new ArrayList<>();

    public TransactionLogger() {
        this.log(ELogType.SYSTEME, "Initialisation de l'enregistreur");
    }

    private String prefixer(ELogType type, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        sb.append(" - ");
        sb.append(Utils.formattedDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        sb.append(" --> ");
        sb.append(message);

        return sb.toString();
    }

    public void log(ELogType type, String message) {
        String entry = prefixer(type, message);
        logs.add(entry);

        System.out.println(entry);
    }
}
