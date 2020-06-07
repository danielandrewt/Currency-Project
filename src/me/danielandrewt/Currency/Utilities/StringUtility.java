package me.danielandrewt.Currency.Utilities;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class StringUtility {

    public static String format(double amount) {
        DecimalFormat df = new DecimalFormat();
        DecimalFormatSymbols symbol = df.getDecimalFormatSymbols();
        symbol.setGroupingSeparator(',');
        symbol.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(symbol);
        df.setGroupingSize(3);
        df.setGroupingUsed(true);
        double roundOff = Math.round(amount * 100.0) / 100.0;
        return df.format(roundOff);
    }
}
