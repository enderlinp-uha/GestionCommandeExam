public class FClient {
    public static Client creerClient(String nom,
                                     String prenom,
                                     String email,
                                     String adresse,
                                     String codePostal,
                                     String ville,
                                     double soldeCompteCourant) {
        return new Client(nom, prenom, email, adresse, codePostal, ville, soldeCompteCourant);
    }
}
