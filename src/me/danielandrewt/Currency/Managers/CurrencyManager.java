package me.danielandrewt.Currency.Managers;

import com.google.common.collect.Lists;
import me.danielandrewt.Currency.CurrencyProject;
import org.bukkit.craftbukkit.Main;

import java.util.List;
import java.util.UUID;

public class CurrencyManager {

    private CurrencyProject plugin;

    public CurrencyManager(CurrencyProject plugin) {
        this.plugin = plugin;
    }

    private List<Currency> currencies = Lists.newArrayList();

    public List<Currency> getCurrencies() {
        return currencies;
    }

    //Method: Adds a new currency
    public void addCurrency(Currency currency) {
        //Do nothing if it already exists
        if (currencies.contains(currency)) {
            return;
        }
        currencies.add(currency);
    }

    public boolean doesCurrencyExists(String currency) {
        for (Currency c : currencies) {
            if (c.getSingularCurrency().equalsIgnoreCase(currency) || c.getPluralCurrency().equalsIgnoreCase(currency)) {
                return true;
            }
        }
        return false;
    }

    public void createCurrency(String singular, String plural) {
        if (doesCurrencyExists(singular) || doesCurrencyExists(plural)) {
            return;
        }
        Currency c = new Currency(UUID.randomUUID(), singular, plural);
        if (currencies.size() == 1) {
            c.setDefaultCurrency(true);
        }
    }

    public Currency getCurrency(UUID uuid) {
        for (Currency c : getCurrencies()) {
            if (!c.getUUID().equals(uuid)) continue;
            return c;
        }
        return null;
    }

    public Currency getDefaultCurrency() {
        for (Currency c : currencies) {
            if (!c.isDefaultCurrency()) continue;
            return c;
        }
        return null;
    }

    public void deleteCurrency(Currency currency) {
        plugin.getData().removeCurrency(currency);
    }
}
