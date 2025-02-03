import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation de la liste des produits
        List<Produit> produits = new ArrayList<Produit>();
        produits.add(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 9.90, 5));
        produits.add();
        System.out.println(produits);
    }
}