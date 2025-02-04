public class ChaineInitialisation {
    private final ICommandeGestionnaire premiereChaine;

    public ChaineInitialisation() {
        this.premiereChaine = new ChaineVerificationStock();
        ICommandeGestionnaire chainePaiement = new ChaineVerificationPaiement();
        ICommandeGestionnaire chaineEnvoi = new ChaineEnvoiCommande();

        this.premiereChaine.setSuivant(chainePaiement);
        chainePaiement.setSuivant(chaineEnvoi);
    }

    public void traiterCommande(Commande commande) {
        STransactionLogger.getInstance().log(ETypeLog.INFO, commande.toString());
        this.premiereChaine.traiterCommande(commande);
        STransactionLogger.getInstance().log(ETypeLog.INFO, commande.toString());
    }
}
