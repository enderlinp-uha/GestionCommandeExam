import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation de la base de données des produits
        ProduitBdd produits = SBaseDeDonneesProduit.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        // produits.afficherListe();

        // Instanciation de la chaîne de responsabilités
        ChaineMaitre chaine = new ChaineMaitre();

        // Instanciation du système de notification
        CommandeNotification systemeNotification = new CommandeNotification();

        // Création d'un nouveau client
        Client client = new Client();
        systemeNotification.ajouterObservateur(client);
        systemeNotification.publierNotification("Cher client, votre panier vient d'être créé");
        //System.out.println(client.recevoirNotification());

        // Ajout des articles au panier
        Panier panier = new Panier();
        panier.ajouter(produits.obtenir(1));
        panier.ajouter(produits.obtenir(3));
        // System.out.println(panier);

        // Création de la commande
        Commande commande = new Commande.CommandeBuilder()
                .setProduits(panier.obtenir())
                .setPrixTotal(panier.calculerPrixTotal())
                .setStatut(EStatutCommande.COURS)
                .build();

        //
    }
}