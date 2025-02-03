public class CommandeNotification implements ISujet {
    private IObservateur observateur;
    private String message = "";

    public CommandeNotification() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation du système de notification");
    }

    public void ajouterObservateur(IObservateur observateur) {
        this.observateur = observateur;
    }

    public void notifierObservateur() {
        this.observateur.actualiser(this.message);
    }

    @Override
    public void publierNotification(String message) {
        this.message = message;
        this.notifierObservateur();
    }
}
