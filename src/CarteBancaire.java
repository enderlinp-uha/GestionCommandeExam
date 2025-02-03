public class CarteBancaire implements IMoyenPaiement {
    private String moyenPaiement = Utils.libelleMoyenPaiement(EMoyenPaiement.CREDIT);

    public CarteBancaire() {
        STransactionLogger.getInstance().log(ELogType.INFO,
                "Initialisation du système de paiement par " + moyenPaiement);
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.INFO, montant + "€ réglés par " + moyenPaiement);
    }
}
