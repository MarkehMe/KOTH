package subside.plugins.koth.commands;

import org.bukkit.command.CommandSender;

import subside.plugins.koth.Lang;
import subside.plugins.koth.commands.CommandHandler.CommandCategory;
import subside.plugins.koth.exceptions.CommandMessageException;
import subside.plugins.koth.utils.IPerm;
import subside.plugins.koth.utils.MessageBuilder;
import subside.plugins.koth.utils.Perm;

public class CommandEnd extends AbstractCommand {

    public CommandEnd(CommandCategory category) {
        super(category);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (args.length > 0) {
            getPlugin().getKothHandler().endKoth(args[0]);
            throw new CommandMessageException(new MessageBuilder(Lang.COMMAND_TERMINATE_SPECIFIC_KOTH).koth(args[0]));
        } else {
            getPlugin().getKothHandler().endAllKoths();
            throw new CommandMessageException(Lang.COMMAND_TERMINATE_ALL_KOTHS);
        }
    }

    @Override
    public IPerm getPermission() {
        return Perm.Control.END;
    }

    @Override
    public String[] getCommands() {
        return new String[]{"end"};
    }
    
    @Override
    public String getUsage() {
        return "/koth end [koth]";
    }

    @Override
    public String getDescription() {
        return "Gracefully ends a (specific) koth";
    }

}
