public class Main {
    public static void main(String[] args) {
        // Initialisation de la base de données des produits
        ProduitBdd produits = SProduitBdd.getInstance();
        produits.ajouterProduit(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.ajouterProduit(FProduit.creerProduit("Blade Runner 2049 4K", ECategorieProduit.BLURAY, 10.86, 8));
        produits.ajouterProduit(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.ajouterProduit(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        produits.ajouterProduit(FProduit.creerProduit("Knight of Cups", ECategorieProduit.DVD, 10.00, 2));

        // Création d'un nouveau client
        Client client = FClient.creerClient(
                "SPONGE",
                "Bob",
                "bob.sponge@uha.fr",
                "Serfa - 61 rue Albert Camus",
                "68200",
                "Mulhouse",
                1000.00);

        // Initialisation de la chaîne de responsabilités
        ChaineInitialisation chaine = new ChaineInitialisation();

        // Initialisation d'un nouveau panier, facilite le calcul du montant total de la commande
        Panier panier = new Panier();

        // Ajout des articles au panier
        panier.ajouterPanier(produits.obtenirProduit(1));
        panier.ajouterPanier(produits.obtenirProduit(3));
        // System.out.println(panier);

        // Construction de la commande, avec règlement par carte bancaire
        Commande commande = FCommande.creerCommandeCarteBancaire(
                client,
                panier.obtenirListeProduitPanier(),
                panier.calculerPrixTotalPanier());

        // Traitement de la commande
        chaine.traiterCommande(commande);

        // On vide le panier
        panier.viderPanier();
        // System.out.println(panier);
    }
}