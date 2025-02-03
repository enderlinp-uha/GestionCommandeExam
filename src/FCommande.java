import java.util.List;

public class FCommande {
    public static Commande creerCommandeCarteBancaire(Client client, List<Produit> produits, double prixTotal) {
        return new Commande.CommandeBuilder()
                .setClient(client)
                .setProduits(produits)
                .setPrixTotal(prixTotal)
                .setMoyenPaiement(EMoyenPaiement.CREDIT)
                .build();
    }
}
