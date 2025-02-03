import java.util.Objects;

public class ChaineEnvoiCommande implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void gererCommande(Commande commande) {
        Client client = commande.getClient();

        // Initialisation du système de notification
        CommandeNotification systemeNotification = new CommandeNotification();
        systemeNotification.ajouterObservateur(client);

        if (Objects.equals(client.getAdresse(), "") || Objects.equals(client.getCodePostal(), "") || Objects.equals(client.getVille(), "")) {

        } else {
            systemeNotification.publierNotification("Cher client, Votre commande vient d'être expédiée. Nous vous remercions de votre confiance.");
        }
    }
}
