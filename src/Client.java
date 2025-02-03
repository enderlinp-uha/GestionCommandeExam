public class Client implements IObservateur {
    private String nom = "";
    private String prenom = "";
    private String email = "";
    private String addresse = "";
    private String codePostal = "";
    private String ville = "";

    private String message;

    public Client(String nom, String prenom, String email, String codePostal, String ville) {
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.addresse = "";
        this.codePostal = "";
        this.ville = "";
    }

    public String recevoirNotification() {
        return this.message;
    }

    @Override
    public void actualiser(String message) {
        this.message = message;
        System.out.println("Nouvelle notification : " + this.message);
    }
}
