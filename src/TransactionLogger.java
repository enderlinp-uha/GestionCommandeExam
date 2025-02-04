import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLogger {
    private List<String> logs = new ArrayList<>();

    public TransactionLogger() {
        this.log(ETypeLog.DEBUG, "Initialisation de l'enregistreur");
    }

    private String prefixerLog(ETypeLog type, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        sb.append(" - ");
        sb.append(Utils.formaterDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        sb.append(" --> ");
        sb.append(message);

        return sb.toString();
    }

    public void log(ETypeLog type, String message) {
        String logPrefixe = prefixerLog(type, message);
        logs.add(logPrefixe);

        System.out.println(logPrefixe);
    }
}
