import java.util.HashMap;

public class ProduitBdd {
    private HashMap<Integer, Produit> produits = new HashMap<>();

    public ProduitBdd() {
        STransactionLogger.getInstance().log(ELogType.SYSTEME, "Initialisation de la base de données des produits");
    }

    public void creer(Produit produit) {
        this.produits.put(produit.getId(), produit);
    }

    public Produit obtenir(int id) {
        return this.produits.get(id);
    }

    public void afficherListe() {
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
