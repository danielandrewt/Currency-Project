package me.danielandrewt.Currency.Commands;

import me.danielandrewt.Currency.CurrencyProject;
import me.danielandrewt.Currency.Managers.Currency;
import me.danielandrewt.Currency.Utilities.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CurrencyCommand implements CommandExecutor {

    private final CurrencyProject plugin = CurrencyProject.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("currency.*") || !sender.hasPermission("currency.managecurrency")) {
            sender.sendMessage(ChatUtils.chat("&cYou do not have permission to perform this!"));
            return false;
        }
        if (args.length == 0) {
            sender.sendMessage(ChatUtils.chat("&c/currency <create> <singular> <plural>"));
        } else {
            if (args[0].equalsIgnoreCase("create")) {
                if (args.length == 3) {
                    String single = args[1];
                    String plural = args[2];
                    if (plugin.getCurrencyManager().doesCurrencyExists(single) || plugin.getCurrencyManager().doesCurrencyExists(plural)) {
                        sender.sendMessage(ChatUtils.chat("&cThat currency already exists!"));
                        return false;
                    }
                    plugin.getCurrencyManager().createCurrency(single, plural);
                    sender.sendMessage(ChatUtils.chat("&aCurrency " + "&e" + single + "&a has been added!"));
                } else {
                    sender.sendMessage(ChatUtils.chat("&cUsage: /currency <create> <singlular> <plural>!"));
                }
            } else if (args[0].equalsIgnoreCase("list")) {
                sender.sendMessage(ChatUtils.chat("&aList of Currencies: "));
                for (Currency currency : plugin.getCurrencyManager().getCurrencies()) {
                    sender.sendMessage(ChatUtils.chat("$e" + currency.getSingularCurrency()));
                }
            }
        }
        return false;
    }
}
