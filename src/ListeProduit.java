import java.util.HashMap;

public class ListeProduit {
    private HashMap<Integer, Produit> produits = new HashMap<>();

    public ListeProduit() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation de la liste des produits");
    }

    public void creer(Produit produit) {
        this.produits.put(produit.getId(), produit);
    }
}
