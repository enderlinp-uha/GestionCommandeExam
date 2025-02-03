public interface ICommandeGestionnaire {
    public void setSuivant(ICommandeGestionnaire suivant);
    public void traiterCommande(Commande commande);
}
