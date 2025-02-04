import java.util.HashMap;

public class ProduitBdd {
    private HashMap<Integer, Produit> produits = new HashMap<>();

    public ProduitBdd() {
        STransactionLogger.getInstance().log(ETypeLog.DEBUG, "Initialisation de la base de données des produits");
    }

    public void ajouterProduit(Produit produit) {
        this.produits.put(produit.getId(), produit);

        STransactionLogger.getInstance().log(ETypeLog.INFO, "Un produit a été ajouté à la base de données : " + produit);
    }

    public Produit obtenirProduit(int id) {
        return this.produits.get(id);
    }

    public void afficherListeProduits() {
        StringBuilder sb = new StringBuilder();

        sb.append("---------- Liste des produits ----------\n");
        for (Produit produit : this.produits.values()) {
            sb.append(produit).append("\n");
        }
        sb.append("----------------------------------------");

        System.out.println(sb);
    }
}
