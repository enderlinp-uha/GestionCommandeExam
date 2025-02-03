public class Produit {
    private int id = 0;
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

    public int obtenirId() {
        return id;
    }

    public ECategorieProduit obtenirCategorie() {
        return categorie;
    }

    public double obtenirPrixUnitaire() {
        return prixUnitaire;
    }

    public int obtenirStock() {
        return stock;
    }

    public void retirerStock() {
        this.stock -= 1;
    }

    @Override
    public String toString() {
        return "Produit{"
                + "id=" + id
                + ", nom='" + nom + '\''
                + ", categorie=" + categorie
                + ", prixUnitaire=" + prixUnitaire
                + ", stock=" + stock
                + '}';
    }
}
