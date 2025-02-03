import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id = 0; // ou -1
    private List<String> produits = new ArrayList<>();
    private double prixTotal = 0.0;
    private EStatutCommande statut;

    private String conclusion = "";

    private Commande(CommandBuilder builder) {
        this.id = builder.id;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;
    }

    public int getId() {
        return id;
    }

    public List<String> getProduits() {
        return produits;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public EStatutCommande getStatut() {
        return statut;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "Commande{"
                + "id=" + id
                + ", produits=" + produits
                + ", prixTotal=" + prixTotal
                + ", statut=" + statut
                + ", conclusion='" + conclusion + '\''
                + "}";
    }

    public static class CommandBuilder {
        private int id;
        private List<String> produits = new ArrayList<>();
        private double prixTotal = 0.0;
        private EStatutCommande statut;

        public CommandBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CommandBuilder setProduits(List<String> produits) {
            this.produits = produits;
            return this;
        }

        public CommandBuilder setPrixTotal(double prixTotal) {
            this.prixTotal = prixTotal;
            return this;
        }

        public CommandBuilder setStatut(EStatutCommande statut) {
            this.statut = statut;
            return this;
        }

        public Commande build() {
            return new Commande(this);
        }
    }
}
