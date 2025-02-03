public class ChaineVerificationStock implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void gererCommande(Commande commande) {
        /*for (Produit produit : commande.getProduits())
            if (SProduitBdd.getInstance().obtenirProduit(produit.obtenirId()).obtenirStock() > 1) {
                return;
            }
        }*/

        suivant.gererCommande(commande);
    }
}
