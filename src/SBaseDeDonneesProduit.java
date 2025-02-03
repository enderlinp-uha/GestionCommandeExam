public class SBaseDeDonneesProduit {
    private static ProduitBdd instance = null;

    public static ProduitBdd getInstance() {
        if (instance == null) {
            instance = new ProduitBdd();
        }
        return instance;
    }
}
