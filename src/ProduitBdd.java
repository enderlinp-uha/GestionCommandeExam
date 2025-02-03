import java.util.HashMap;

public class ProduitBdd {
    private HashMap<Integer, Produit> produits = new HashMap<>();

    public ProduitBdd() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation de la base de données des produits");
    }

    public void creer(Produit produit) {
        this.produits.put(produit.obtenirId(), produit);
    }

    public Produit obtenirProduit(int id) {
        return this.produits.get(id);
    }

    public void afficherListeProduits() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nListe des produits :\n");
        for (Produit produit : this.produits.values()) {
            sb.append(produit);
            sb.append("\n");
        }
        String sortie = sb.toString();

        System.out.println(sortie);
    }
}
