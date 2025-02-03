public class ChaineVerificationPaiement implements ICommandeGestionnaire{
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void gererCommande(Commande commande) {
        // Initialisation du système de notification
        CommandeNotification systemeNotification = new CommandeNotification();
        systemeNotification.ajouterObservateur(commande.getClient());

        Client client = commande.getClient();
        double prixTotal = commande.getPrixTotal();

        if (prixTotal > client.getCompteCourant()) {
            commande.setConclusion("Compte courant insuffisant. Commande annulée");
            systemeNotification.publierNotification("Cher client, Une erreur est survenue lors du règlement. Votre commande a été annulée.");
        } else {
            client.debiterCompteCourant(prixTotal);

            // Initialisation du système de paiement et règlement par carte bancaire
            IMoyenPaiement moyenPaiement = FMoyenPaiement.payerCarteBancaire();
            moyenPaiement.payer(prixTotal);

            suivant.gererCommande(commande);
        }
    }
}
