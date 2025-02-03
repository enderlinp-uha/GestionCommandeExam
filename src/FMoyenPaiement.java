public class FMoyenPaiement {
    public static IMoyenPaiement creerMoyenPaiement(EMoyenPaiement type) {
        return switch(type) {
            case CREDIT -> new CarteBancaire();
            case CRYPTO -> new Cryptomonnaie();
            case PAYPAL -> new PayPal();
        };
    }
}
