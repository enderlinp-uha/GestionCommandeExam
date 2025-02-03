import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialisation de la liste des produits
        ListeProduit produits = SListeProduit.getInstance();
        produits.creer(FProduit.creerProduit("Blade Runner", ECategorieProduit.LIVRE, 8.00, 5));
        produits.creer(FProduit.creerProduit("Interstellar", ECategorieProduit.DVD, 7.45, 10));
        System.out.println(produits);
    }
}