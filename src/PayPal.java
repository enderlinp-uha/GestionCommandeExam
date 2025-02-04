public class PayPal implements IMoyenPaiement {
    private final String moyenPaiement = Utils.libelleMoyenPaiement(EMoyenPaiement.PAYPAL);

    public PayPal() {
        STransactionLogger.getInstance().log(ELogType.DEBUG, "Initialisation du système de paiement par " + moyenPaiement);
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.INFO, montant + " € réglés par " + moyenPaiement);
    }
}
