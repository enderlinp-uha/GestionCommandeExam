public class ChaineMaitre {
    private ICommandeGestionnaire premiereChaine;

    public ChaineMaitre() {
        this.premiereChaine = new ChaineVerificationStock();
        ICommandeGestionnaire chainePaiement = new ChaineVerificationPaiement();
        ICommandeGestionnaire chaineEnvoi = new ChaineEnvoiCommande();

        this.premiereChaine.setSuivant(chainePaiement);
        chainePaiement.setSuivant(chaineEnvoi);
    }

    public void gererCommande(Commande commande) {
        STransactionLogger.getInstance().log(ELogType.STATUT, commande.toString());

        this.premiereChaine.gererCommande(commande);

        STransactionLogger.getInstance().log(ELogType.STATUT, commande.toString());
    }
}
