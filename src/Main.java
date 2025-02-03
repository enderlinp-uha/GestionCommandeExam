public class Main {
    public static void main(String[] args) {
        // Initialisation de la liste des produits
        ListeProduit produits = SListeProduit.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("2001 : L'Odyssée de l'espace", ECategorieProduit.LIVRE, 8.40, 3));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));

        // Afficher la liste des produits
        produits.afficher();
    }
}