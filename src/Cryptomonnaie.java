public class Cryptomonnaie implements IMoyenPaiement {
    private final String moyenPaiement = Utils.libelleMoyenPaiement(EMoyenPaiement.CRYPTO);

    public Cryptomonnaie() {
        STransactionLogger.getInstance().log(ELogType.DEBUG, "Initialisation du système de paiement par " + moyenPaiement);
    }

    @Override
    public void payer(double montant) {
        STransactionLogger.getInstance().log(ELogType.INFO, montant + " € réglés par " + moyenPaiement);
    }
}
