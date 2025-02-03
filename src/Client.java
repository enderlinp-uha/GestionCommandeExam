public class Client implements IObservateur {
    private String nom = "";
    private String prenom = "";
    private String email = "";
    private String adresse = "";
    private String codePostal = "";
    private String ville = "";
    private double compteCourant = 0.0;

    private String message;

    public Client(String nom, String prenom, String email, String adresse, String codePostal, String ville, double compteCourant) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.compteCourant = compteCourant;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public double getCompteCourant() {
        return this.compteCourant;
    }

    public void debiterCompteCourant(double montant) {
        this.compteCourant -= montant;
    }

    public String recevoirNotification() {
        return this.message;
    }

    @Override
    public void actualiser(String message) {
        this.message = message;
        System.out.println("Nouvelle notification : " + this.message);
    }

    @Override
    public String toString() {
        return "Client{"
                + "nom='" + nom + '\''
                + ", prenom='" + prenom + '\''
                + ", email='" + email + '\''
                + ", adresse='" + adresse + '\''
                + ", codePostal='" + codePostal + '\''
                + ", ville='" + ville + '\''
                + ", compteCourant=" + compteCourant
                + ", message='" + message + '\''
                + '}';
    }
}
