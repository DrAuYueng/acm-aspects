package com.acm.LogUtil;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GenerateSequenceUtils {
    private GenerateSequenceUtils() {
    };

    private static final FieldPosition FIELD_POSITION = new FieldPosition(NumberFormat.INTEGER_FIELD);

    private static final Format DATE_FORMAT = new SimpleDateFormat("MMddHHmmssS");

    private static final NumberFormat NUMBER_FORMAT = new DecimalFormat("0000");

    private static int SEQ = 0;

    private static final int MAX = 9999;

    private static final byte[] KEY = new byte[0];

    public static String generateSequence() {

        StringBuffer sb = new StringBuffer();
        DATE_FORMAT.format(Calendar.getInstance().getTime(), sb, FIELD_POSITION);

        int tmp = 0;
        synchronized (KEY) {
            if (SEQ >= MAX) {
                SEQ = 0;
            } else {
                SEQ++;
            }
            tmp = SEQ;
        }

        NUMBER_FORMAT.format(tmp, sb, FIELD_POSITION);
        return sb.toString();
    }
}
