public class PayPal implements IMoyenPaiement {
    public PayPal() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation du système de paiement par " + Utils.libelleMoyenPaiement(EMoyenPaiement.PAYPAL));
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.INFO, montant + "€ réglés par " + Utils.libelleMoyenPaiement(EMoyenPaiement.PAYPAL));
    }
}
