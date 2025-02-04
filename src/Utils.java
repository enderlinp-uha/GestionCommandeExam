import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Utils {
    public static double arrondirDouble(double valeur, int decimales) {
        double denominateur = Math.pow(10, decimales);

        return Math.round(valeur * denominateur) / denominateur;
    }

    public static boolean estMoyenPaiement(EMoyenPaiement type) {
        return Arrays.asList(Utils.obtenirMoyenPaiement()).contains(type);
    }

    public static String formaterDate(Date date, String format) {
        SimpleDateFormat nouvelleDate = new SimpleDateFormat(format);

        return nouvelleDate.format(date);
    }

    public static String libelleMoyenPaiement(EMoyenPaiement type) {
        return switch (type) {
            case CREDIT -> "Carte bancaire";
            case CRYPTO -> "Cryptomonnaie";
            case PAYPAL -> "PayPal";
        };
    }

    public static EMoyenPaiement[] obtenirMoyenPaiement() {
        return new EMoyenPaiement[]{ EMoyenPaiement.CREDIT, EMoyenPaiement.CRYPTO, EMoyenPaiement.PAYPAL };
    }
}
