import java.util.HashMap;

public class ProduitBdd {
    private HashMap<Integer, Produit> produits = new HashMap<>();

    public ProduitBdd() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation de la base de données des produits");
    }

    public void ajouterProduit(Produit produit) {
        this.produits.put(produit.obtenirId(), produit);

        STransactionLogger.getInstance().log(ELogType.INFO, "Un produit a été ajouté à la base de données : " + produit.toString());
    }

    public Produit obtenirProduit(int id) {
        return this.produits.get(id);
    }

    public void afficherListeProduits() {
        StringBuilder sb = new StringBuilder();

        sb.append("---------- Liste des produits ----------\n");
        for (Produit produit : this.produits.values()) {
            sb.append(produit);
            sb.append("\n");
        }
        sb.append("----------------------------------------");

        System.out.println(sb);
    }
}
