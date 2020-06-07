package me.danielandrewt.Currency;

import me.danielandrewt.Currency.Abstracts.Data;
import me.danielandrewt.Currency.Managers.CurrencyManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CurrencyProject extends JavaPlugin {

    private static CurrencyProject plugin;
    private CurrencyManager currencyManager;
    private Data data;

    public static CurrencyProject getInstance() {
        return plugin;
    }

    public Data getData() {
        return data;
    }

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }
}
