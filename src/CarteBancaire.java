public class CarteBancaire implements IMoyenPaiement {
    public CarteBancaire() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation du système de paiement par " + Utils.libelleMoyenPaiement(EMoyenPaiement.CREDIT));
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.PAIEMENT, montant + "€ réglés par " + Utils.libelleMoyenPaiement(EMoyenPaiement.CREDIT));
    }
}
