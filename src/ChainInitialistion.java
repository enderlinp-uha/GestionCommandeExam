public class ChainInitialistion {
    private ICommandeGestionnaire premiereChaine;

    public ChainInitialistion() {
        this.premiereChaine = new ChainVerificationStock();
        ICommandeGestionnaire chainePaiement = new ChainVerificationPaiement();
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
