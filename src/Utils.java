import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formattedDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}
