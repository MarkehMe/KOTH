package subside.plugins.koth.commands;

import org.bukkit.command.CommandSender;

import subside.plugins.koth.Lang;
import subside.plugins.koth.commands.CommandHandler.CommandCategory;
import subside.plugins.koth.exceptions.CommandMessageException;
import subside.plugins.koth.utils.IPerm;
import subside.plugins.koth.utils.MessageBuilder;
import subside.plugins.koth.utils.Perm;

public class CommandStop extends AbstractCommand {

    public CommandStop(CommandCategory category) {
        super(category);
    }

    @Override
    public void run(CommandSender sender, String[] args) {
        if (args.length > 0) {
            getPlugin().getKothHandler().stopKoth(args[0]);
            throw new CommandMessageException(new MessageBuilder(Lang.COMMAND_TERMINATE_SPECIFIC_KOTH).koth(args[0]));
        } else {
           getPlugin().getKothHandler().stopAllKoths();
            throw new CommandMessageException(Lang.COMMAND_TERMINATE_ALL_KOTHS);
        }
    }

    @Override
    public IPerm getPermission() {
        return Perm.Control.STOP;
    }

    @Override
    public String[] getCommands() {
        return new String[]{"stop"};
    }
    
    @Override
    public String getUsage() {
        return "/koth stop [koth]";
    }

    @Override
    public String getDescription() {
        return "Stops a (specific) koth";
    }

}
