public interface ICommandeGestionnaire {
    public void setSuivant(ICommandeGestionnaire suivant);
    public void gererCommande(Commande commande);
}
