public class Cryptomonnaie implements IMoyenPaiement {
    public Cryptomonnaie() {
        STransactionLogger.getInstance().log(ELogType.INFO, "Initialisation du système de paiement par " + Utils.libelleMoyenPaiement(EMoyenPaiement.CRYPTO));
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.NOTICE, montant + " € réglés par " + Utils.libelleMoyenPaiement(EMoyenPaiement.CRYPTO));
    }
}
