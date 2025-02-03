public class Produit {
    private int id = -1;
    private String nom = "";
    private ECategorieProduit categorie;
    private double prixUnitaire = 0.0;
    private int stock = 0;

    public Produit(int id, String nom, ECategorieProduit categorie, double prixUnitaire, int stock) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.prixUnitaire = prixUnitaire;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{"
                + "id=" + id
                + ", nom='" + nom + '\''
                + ", categorie=" + categorie
                + ", prixUnitaire=" + prixUnitaire
                + ", stock=" + stock
                + "}";
    }
}
