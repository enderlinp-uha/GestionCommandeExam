public class FProduit {
    private static int id = 0;

    public static Produit creerProduit(String nom, ECategorieProduit categorie, double prixUnitaire, int stock) {
        return new Produit(++id, nom, categorie, prixUnitaire, stock);
    }
}
