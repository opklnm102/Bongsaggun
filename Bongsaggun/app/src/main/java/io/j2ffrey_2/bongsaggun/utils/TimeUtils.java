package io.j2ffrey_2.bongsaggun.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dong on 2015-11-07.
 */
public class TimeUtils {

    public static final String TAG = TimeUtils.class.getSimpleName();

    public static String conver() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);

        return null;
    }

    public static int dateToYear(String strDate) {

        String[] str = strDate.split("-");

        return Integer.valueOf(str[0]);
    }

    public static int dateToMonth(String strDate) {

        String[] str = strDate.split("-");

        return Integer.valueOf(str[1]);
    }

    public static int dateToDday(String strDate) {

        SimpleDateFormat convertedSdf = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

        Date timeDate = null;  //String -> Date
        try {
            timeDate = convertedSdf.parse(strDate);

            Log.d(TAG, " " + timeDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long current = calendar.getTimeInMillis() + (24 * 60 * 60 * 1000);  //일에 + 1

        Log.d(TAG, "current " + (calendar.get(Calendar.DAY_OF_MONTH) + 1));

        long feature = timeDate.getTime();

        Long dDay = (feature - current) / (24 * 60 * 60 * 1000);

        Log.d(TAG, "dDay " + dDay);

        return dDay.intValue();
    }
}
