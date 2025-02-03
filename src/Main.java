public class Main {
    public static void main(String[] args) {
        // Initialisation de la base de données des produits
        ProduitBdd produits = SProduitBdd.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        produits.creer(FProduit.creerProduit("Knight of Cups", ECategorieProduit.DVD, 10.00, 2));
        //produits.afficherListeProduits();

        // Création d'un nouveau client
        Client client = FClient.creerClient(
                "SPONGE",
                "Bob",
                "spongebob@uha.fr",
                "Serfa - 61 rue Albert Camus",
                "68200",
                "Mulhouse",
                1000.0);

        // Initialisation de la chaîne de responsabilités
        ChainInitialistion chaine = new ChainInitialistion();

        // Initialisation d'un nouveau panier
        Panier panier = new Panier();

        // Ajout des articles au panier
        panier.ajouterPanier(produits.obtenirProduit(1));
        panier.ajouterPanier(produits.obtenirProduit(4));

        // Construction de la commande, avec règlement par carte bancaire
        Commande commande = FCommande.creerCommandeCarteBancaire(
                client,
                panier.obtenirListeProduitPanier(),
                panier.calculerPrixTotalPanier());

        // Traitement de la commande
        chaine.traiterCommande(commande);
    }
}