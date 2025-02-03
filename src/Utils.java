import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String libelleMoyenPaiement(EMoyenPaiement type) {
        return switch (type) {
            case CREDIT -> "Carte bancaire";
            case CRYPTO -> "Cryptomonnaie";
            case PAYPAL -> "PayPal";
        };
    }

    public static String formaterDate(Date date, String format) {
        SimpleDateFormat nouvelleDate = new SimpleDateFormat(format);
        return nouvelleDate.format(date);
    }
}
