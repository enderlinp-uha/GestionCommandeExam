public class Main {
    public static void main(String[] args) {
        // Initialisation de la base de données des produits
        ProduitBdd produits = SProduitBdd.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        produits.creer(FProduit.creerProduit("Knight of Cups", ECategorieProduit.DVD, 10.00, 3));
        produits.afficherListeProduits();

        // Initialisation de la chaîne de responsabilités
        ChaineInitialistion chaine = new ChaineInitialistion();

        // Création d'un nouveau client
        Client client = new Client("L'éponge", "Bob", "spongebob@uha.fr", "68200", "Mulhouse");

        // Initialisation du système de notification
        CommandeNotification systemeNotification = new CommandeNotification();
        systemeNotification.ajouterObservateur(client);

        // Ajout des articles au panier
        Panier panier = new Panier();
        panier.ajouterPanier(produits.obtenirProduit(1));
        panier.ajouterPanier(produits.obtenirProduit(4));
        // System.out.println(panier);

        // Calcul du prix total du panier
        double prixTotal = panier.calculerPrixTotalPanier();

        // Construction de la commande
        Commande commande = new Commande.CommandeBuilder()
                .setClient(client)
                .setProduits(panier.obtenirPanier())
                .setPrixTotal(prixTotal)
                .build();

        // Envoi d'une notification au client
        systemeNotification.publierNotification("Cher client, votre commande vient d'être créé.");

        // Initialisation du système de paiement
        IMoyenPaiement moyenPaiement = FMoyenPaiement.payerCarteBancaire();
        moyenPaiement.payer(prixTotal);

        systemeNotification.publierNotification("Cher client, votre commande vient d'être validée.");
        systemeNotification.publierNotification("Cher client, votre commande vient d'être expédiée.");
    }
}