public class ChainVerificationStock implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void traiterCommande(Commande commande) {
        Client client = commande.getClient();

        // Initialisation du système de notification
        CommandeNotification systemeNotification = SCommandeNotification.getInstance();
        systemeNotification.ajouterObservateur(client);

        // Si le stock est vide pour au moins un article
        for (Produit produit : commande.getProduits()) {
            int stock = produit.obtenirStock();

            if (stock > 1) {
                produit.retirerStock();
            } else {
                commande.setStatut(false);
                commande.setConclusion("Stock insuffisant. Commande annulée");
                systemeNotification.publierNotification("Cher client, "
                        + "Un ou plusieurs articles de votre panier ne sont plus en stock. "
                        + "Nous sommes au regret de vous anoncer que votre commande a été annulée.");
                System.out.println(client.recevoirNotification());

                return;
            }
        }

        systemeNotification.publierNotification("Cher client, " +
                "Nous avons le plaisir de vous annoncer que votre commande vient d'être créé.");
        System.out.println(client.recevoirNotification());

        if (suivant != null) {
            suivant.traiterCommande(commande);
        }
    }
}
