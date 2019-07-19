import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {
    public static int daysBetween(GregorianCalendar from, GregorianCalendar to) {
        //Calendar calendar = Calendar.getInstance();
        // TODO: 2019-05-18
        long start = from.getTimeInMillis();
        long end = to.getTimeInMillis();

        return (int) TimeUnit.MILLISECONDS.toDays(end - start);
    }


}
