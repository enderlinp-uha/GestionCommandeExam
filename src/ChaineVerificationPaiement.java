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

        if (commande.getPrixTotal() > commande.getClient().getCompteCourant()) {
            commande.setConclusion("Compte courant insuffisant");
            systemeNotification.publierNotification("Cher client, Une erreur est survenu lors du règlement. Votre commande a été annulée.");
        } else {
            suivant.gererCommande(commande);
        }

    }
}
