public class ChaineVerificationPaiement implements ICommandeGestionnaire{
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void gererCommande(Commande commande) {

    }
}
