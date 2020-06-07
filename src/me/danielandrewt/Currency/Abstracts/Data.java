package me.danielandrewt.Currency.Abstracts;

import me.danielandrewt.Currency.CurrencyProject;
import me.danielandrewt.Currency.Managers.Currency;


public abstract class Data {

    public final CurrencyProject plugin = CurrencyProject.getInstance();

    public abstract void saveCurrency(Currency currency);

    public abstract void loadCurrency();

    public abstract void removeCurrency(Currency currency);

}
