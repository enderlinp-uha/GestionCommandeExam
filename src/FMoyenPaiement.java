public class FMoyenPaiement {
    public static IMoyenPaiement payerCarteBancaire() {
        return new CarteBancaire();
    }

    public static IMoyenPaiement payerCryptomonnaie() {
        return new Cryptomonnaie();
    }

    public static IMoyenPaiement payerPayPal() {
        return new PayPal();
    }
}
