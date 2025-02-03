import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> panier = new ArrayList<>();

    public void ajouterPanier(Produit produit) {
        panier.add(produit);
    }

    public List<Produit> obtenirListeProduitPanier() {
        return panier;
    }

    public double calculerPrixTotalPanier() {
        double total = 0;

        for (Produit produit : panier) {
            total += produit.obtenirPrixUnitaire();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Panier{"
                + "panier=" + panier
                + '}';
    }
}
