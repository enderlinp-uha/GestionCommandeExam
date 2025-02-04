public class ChaineInitialisation {
    private ICommandeGestionnaire premiereChaine;

    public ChaineInitialisation() {
        this.premiereChaine = new ChaineVerificationStock();
        ICommandeGestionnaire chaineVerificationPaiement = new ChaineVerificationPaiement();
        ICommandeGestionnaire chaineEnvoiCommande = new ChaineEnvoiCommande();

        this.premiereChaine.setSuivant(chaineVerificationPaiement);
        chaineVerificationPaiement.setSuivant(chaineEnvoiCommande);
    }

    public void traiterCommande(Commande commande) {
        STransactionLogger.getInstance().log(ETypeLog.INFO, commande.toString());

        this.premiereChaine.traiterCommande(commande);

        STransactionLogger.getInstance().log(ETypeLog.INFO, commande.toString());
    }
}
