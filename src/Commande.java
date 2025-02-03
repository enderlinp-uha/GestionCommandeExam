import java.util.ArrayList;
import java.util.List;

public class Commande {
    private static int increment = 0;
    private int id = 0;
    private Client client;
    private List<Produit> produits = new ArrayList<>();
    private double prixTotal = 0.0;
    private boolean statut = false;

    private String conclusion = "";

    private Commande(CommandeBuilder builder) {
        this.id = builder.id;
        this.client = builder.client;
        this.produits = builder.produits;
        this.prixTotal = builder.prixTotal;
        this.statut = builder.statut;

        STransactionLogger.getInstance().log(ELogType.STATUT, "Commande en cours");
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public boolean getStatut() {
        return statut;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setId(int id) {
        this.id = id;
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
                + ", statut=" + statut
                + ", conclusion='" + conclusion + '\''
                + "}";
    }

    public static class CommandeBuilder {
        private int id;
        private Client client;
        private List<Produit> produits = new ArrayList<>();
        private double prixTotal = 0.0;
        private boolean statut;

        public CommandeBuilder() {
            this.id = ++increment;
        }

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

        public CommandeBuilder setStatut(boolean statut) {
            this.statut = statut;
            return this;
        }

        public Commande build() {
            return new Commande(this);
        }
    }
}
