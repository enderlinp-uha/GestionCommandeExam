import java.util.Objects;

public class ChaineEnvoiCommande implements ICommandeGestionnaire {
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void traiterCommande(Commande commande) {
        Client client = commande.getClient();

        // Initialisation du système de notification
        CommandeNotification systemeNotification = SCommandeNotification.getInstance();

        if (Objects.equals(client.getAdresse(), "")
                || Objects.equals(client.getCodePostal(), "")
                || Objects.equals(client.getVille(), "")) {

            commande.setStatut(false);
            commande.setConclusion("Adresse incomplète. Commande annulée");
            systemeNotification.publierNotification("Cher client, "
                    + "Votre adresse étant incomplète, vos articles n'ont pu être expédiés. "
                    + "Nous vous prions de bien vouloir nous contacter pour procéder à leur expédition.");
            System.out.println(client.recevoirNotification());
        } else {
            commande.setStatut(true);
            commande.setConclusion("Commande terminée");
            systemeNotification.publierNotification("Cher client, "
                    + "Votre commande vient d'être expédiée. "
                    + "Nous vous remercions de votre confiance.");
            System.out.println(client.recevoirNotification());
        }
    }
}
