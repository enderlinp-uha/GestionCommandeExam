import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> panier = new ArrayList<>();

    public void ajouter(Produit produit) {
        panier.add(produit);
    }

    public List<Produit> obtenir() {
        return panier;
    }

    public double calculerPrixTotal() {
        double total = 0;

        for (Produit produit : panier) {
            total += produit.getPrixUnitaire();
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
