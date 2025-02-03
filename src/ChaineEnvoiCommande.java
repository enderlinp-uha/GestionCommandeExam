public class ChaineEnvoiCommande implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void gererCommande(Commande commande) {

    }
}
