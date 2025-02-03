import java.util.ArrayList;
import java.util.List;

public class CommandeNotification implements ISujet {
    private List<IObservateur> observateurs;
    private String message;

    public CommandeNotification() {
        observateurs = new ArrayList<IObservateur>();
        STransactionLogger.getInstance().log(ELogType.SYSTEME, "Initialisation du système de notification");
    }

    public void ajouterObservateur(IObservateur observateur) {
        observateurs.add(observateur);
    }

    public void notifierObservateur() {
        for (IObservateur o : observateurs) {
            o.actualiser(this.message);
        }
    }

    @Override
    public void publierNotification(String message) {
        this.message = message;
        this.notifierObservateur();
    }
}
