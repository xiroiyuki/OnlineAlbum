import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

public class Playground {


    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(Calendar.MONTH, 1);
        int res1 = calendar.getActualMinimum(Calendar.HOUR_OF_DAY);
        int res = calendar.getActualMaximum(Calendar.HOUR_OF_DAY);
        System.out.println(res1);
        System.out.println(res);


    }
}
