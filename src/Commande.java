import java.util.ArrayList;
import java.util.List;

public class Commande {
    private static int autoIncrement = 0;
    private int id = 0;
    private Client client;
    private List<Produit> produits = new ArrayList<>();
    private double prixTotal = 0.0;
    private EMoyenPaiement moyenPaiement;
    private boolean statut = false;

    private String conclusion = "";

    private Commande(CommandeBuilder builder) {
        this.id = builder.id;
        this.client = builder.client;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.moyenPaiement = builder.moyenPaiement;
        this.statut = builder.statut;
    }

    public int getId() {
        return this.id;
    }

    public Client getClient() {
        return this.client;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public double getPrixTotal() {
        return this.prixTotal;
    }

    public EMoyenPaiement getMoyenPaiement() {
        return this.moyenPaiement;
    }

    public boolean getStatut() {
        return this.statut;
    }

    public String getConclusion() {
        return this.conclusion;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return "Commande{"
                + "id=" + id
                + ", client=" + client.toString()
                + ", produits=" + produits
                + ", prixTotal=" + prixTotal
                + ", moyenPaiement=" + moyenPaiement
                + ", statut=" + statut
                + ", conclusion='" + conclusion + '\''
                + "}";
    }

    public static class CommandeBuilder {
        private int id;
        private Client client;
        private List<Produit> produits = new ArrayList<>();
        private double prixTotal = 0.0;
        private EMoyenPaiement moyenPaiement;
        private boolean statut;

        public CommandeBuilder() {}

        public CommandeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CommandeBuilder setClient(Client client) {
            this.client = client;
            return this;
        }

        public CommandeBuilder setProduits(List<Produit> produits) {
            this.produits = produits;
            return this;
        }

        public CommandeBuilder setPrixTotal(double prixTotal) {
            this.prixTotal = prixTotal;
            return this;
        }

        public CommandeBuilder setMoyenPaiement(EMoyenPaiement moyenPaiement) {
            this.moyenPaiement = moyenPaiement;
            return this;
        }

        public CommandeBuilder setStatut(boolean statut) {
            this.statut = statut;
            return this;
        }

        public Commande build() {
            this.id = ++autoIncrement;
            return new Commande(this);
        }
    }
}
