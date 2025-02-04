public class SProduitBdd {
    private static ProduitBdd instance = null;

    private SProduitBdd() {}

    public static ProduitBdd getInstance() {
        if (instance == null) {
            instance = new ProduitBdd();
        }

        return instance;
    }
}
