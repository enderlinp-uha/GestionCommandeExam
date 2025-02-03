public class SProduitBdd {
    private static ProduitBdd instance = null;

    public SProduitBdd() {}

    public static ProduitBdd getInstance() {
        if (instance == null) {
            instance = new ProduitBdd();
        }
        return instance;
    }
}
