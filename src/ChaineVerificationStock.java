public class ChaineVerificationStock implements ICommandeGestionnaire {
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

        // Si le stock est vide pour au moins un article
        for (Produit produit : commande.getProduits()) {
            int stock = produit.obtenirStock();
            if (stock > 1) {
                produit.retirerStock();
            } else {
                commande.setConclusion("Article(s) manquant(s). Commande annulée");
                systemeNotification.publierNotification("Cher client, Un ou plusieurs articles de votre panier ne sont plus en stock. Votre commande a été annulée.");
                return;
            }
        }

        systemeNotification.publierNotification("Cher client, Votre commande vient d'être créé.");
        suivant.gererCommande(commande);
    }
}
