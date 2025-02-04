import java.util.HashMap;
import java.util.Map;

public class ChaineVerificationStock implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void traiterCommande(Commande commande) {
        Client client = commande.getClient();
        String prenomClient = client.getPrenom();

        // Initialisation du système de notification
        CommandeNotification systemeNotification = SCommandeNotification.getInstance();
        systemeNotification.ajouterObservateur(client);

        // On récupère les quantités souhaitées pour chaque article qui se trouve dans le panier
        HashMap<Produit, Integer> quantitesPanier = new HashMap<>();
        for (Produit produit : commande.getProduits()) {
            quantitesPanier.put(produit, quantitesPanier.getOrDefault(produit, 0) + 1);
        }

        // On vérifie la disponibilité des articles dans le stock
        for (Map.Entry<Produit, Integer> quantite : quantitesPanier.entrySet()) {
            Produit produit = quantite.getKey();

            if (produit.getStock() < quantite.getValue()) {
                commande.setStatut(false);
                commande.setConclusion("Stock insuffisant. Commande annulée");
                systemeNotification.publierNotification("Cher "
                        + prenomClient + ", "
                        + "Un ou plusieurs articles de votre panier ne sont plus en stock. "
                        + "Nous sommes au regret de vous anoncer que votre commande a été annulée.");
                System.out.println(client.recevoirNotification());

                return;
            }
        }

        // On retire les articles du stock correspondant à ceux du panier
        for (Produit produit : commande.getProduits()) {
            // On ne retire qu'un élément à la fois
            produit.retirerStock();
        }

        systemeNotification.publierNotification("Cher "
                + prenomClient + ", "
                + "Nous avons le plaisir de vous annoncer que votre commande a été créé. "
                + "Nous vous remercions de votre confiance.");
        System.out.println(client.recevoirNotification());

        if (suivant != null) {
            suivant.traiterCommande(commande);
        }
    }
}
