import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date getDate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        return df.parse(date);
    }
}
