public class CarteBancaire implements IMoyenPaiement {
    private final String moyenPaiement = Utils.libelleMoyenPaiement(EMoyenPaiement.CREDIT);

    public CarteBancaire() {
        STransactionLogger.getInstance().log(ETypeLog.DEBUG, "Initialisation du système de paiement par " + moyenPaiement);
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ETypeLog.INFO, montant + "€ réglés par " + moyenPaiement);
    }
}
