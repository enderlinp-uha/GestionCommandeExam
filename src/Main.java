public class Main {
    public static void main(String[] args) {
        // Initialisation de la base de données des produits
        ProduitBdd produits = SProduitBdd.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        produits.creer(FProduit.creerProduit("Knight of Cups", ECategorieProduit.DVD, 10.00, 3));
        // produits.afficherListeProduits();

        // Création d'un nouveau client
        Client client = new Client("L'éponge", "Bob", "spongebob@uha.fr", "SERFA", "68200", "Mulhouse", 100.0);

        // Initialisation de la chaîne de responsabilités
        ChaineInitialistion chaine = new ChaineInitialistion();

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

        // Traitement de la commande
        chaine.gererCommande(commande);
    }
}