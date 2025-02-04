import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> panier = new ArrayList<>();

    public double calculerPrixTotalPanier() {
        double total = 0;

        for (Produit produit : panier) {
            total += produit.obtenirPrixUnitaire();
        }

        total = Utils.arrondirDouble(total, 2);

        return total;
    }

    public List<Produit> obtenirListeProduitPanier() {
        return panier;
    }

    public void ajouterPanier(Produit produit) {
        panier.add(produit);
    }

    public void viderPanier() {
        panier.clear();
    }

    @Override
    public String toString() {
        return "Panier{"
                + "panier=" + panier
                + '}';
    }
}
