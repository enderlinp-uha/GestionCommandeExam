public class ChainVerificationPaiement implements ICommandeGestionnaire{
    private ICommandeGestionnaire suivant = null;

    @Override
    public void setSuivant(ICommandeGestionnaire suivant) {
        this.suivant = suivant;
    }

    @Override
    public void traiterCommande(Commande commande) {
        // On vérifie la validité du moyen de paiement
        if (!Utils.estMoyenPaiement(commande.getMoyenPaiement())) {
            suivant.traiterCommande(commande);
        }

        Client client = commande.getClient();
        String prenomClient = client.getPrenom();
        double prixTotal = commande.getPrixTotal();

        // Initialisation du système de notification
        CommandeNotification systemeNotification = SCommandeNotification.getInstance();

        if (prixTotal > client.getSoldeCompteCourant()) {
            commande.setStatut(false);
            commande.setConclusion("Solde insuffisant. Commande annulée");
            systemeNotification.publierNotification("Cher "
                    + prenomClient + ", "
                    + "Une erreur est survenue lors du règlement en ligne. "
                    + "Nous sommes au regret de vous anoncer que votre commande a été annulée.");
            System.out.println(client.recevoirNotification());
        } else {
            // Initialisation du système de paiement et règlement de la commande
            IMoyenPaiement moyenPaiement = FMoyenPaiement.creerMoyenPaiement(commande.getMoyenPaiement());
            moyenPaiement.payer(prixTotal);

            // On débite le compte courant du client du montant total de la commande
            client.debiterCompteCourant(prixTotal);

            // Construction du récapitulatif de la commande
            StringBuilder sb = new StringBuilder();
            sb.append("Cher ").append(prenomClient).append(", ");
            sb.append("Nous avons le plaisir de vous annoncer que votre commande a été validée dans sa totalité. ");
            sb.append("Vous trouverez ci-dessous un récapitulatif des articles commandés : ");
            for (Produit produit : commande.getProduits()) {
                sb.append(produit.formaterProduit());
            }
            sb.append("Prix total de la commande : ").append(prixTotal).append(" €. ");
            sb.append("Nous vous remercions de votre confiance.");

            systemeNotification.publierNotification(sb.toString());
            System.out.println(client.recevoirNotification());

            if (suivant != null) {
                suivant.traiterCommande(commande);
            }
        }
    }
}
