package me.danielandrewt.Currency.Managers;

import me.danielandrewt.Currency.Utilities.StringUtility;

import java.text.NumberFormat;
import java.util.UUID;

public class Currency {

    private UUID uuid;
    private String singularCurrency;
    private String pluralCurrency;
    private double startingBalance = 0.0;
    private boolean decimalAllowed = false;
    private boolean defaultCurrency = false;

    public Currency(UUID uuid, String singular, String plural) {
        this.uuid = uuid;
        this.singularCurrency = singular;
        this.pluralCurrency = plural;
    }

    public String format(double amount) {
        StringBuilder sb = new StringBuilder();
        if (this.isDecimalAllowed()) {
            sb.append(StringUtility.format(amount));
        } else {
            String s = String.valueOf(amount);
            String[] sa = s.split(".");
            if (sa.length > 0) {
                s = sa[0];
            }
            sb.append(NumberFormat.getInstance().format(Double.parseDouble(s)));
        }
        return sb.toString();
    }

    public void setDecimalAllowed(boolean decimalAllowed) {

        this.decimalAllowed = decimalAllowed;
    }

    public boolean isDecimalAllowed() {

        return this.decimalAllowed;
    }

    public void setSingularCurrency(String singular) {
        this.singularCurrency = singular;
    }

    public void setPluralCurrency(String plural) {
        this.pluralCurrency = plural;
    }

    public void setStartingBalance(double startingBalance) {
        this.startingBalance = startingBalance;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public boolean isDefaultCurrency() {
        return this.defaultCurrency;
    }

    public void setDefaultCurrency(boolean defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getSingularCurrency() {
        return this.singularCurrency;
    }

    public String getPluralCurrency() {
        return this.pluralCurrency;
    }
}
