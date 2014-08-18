package io.github.schemen.kickmyself;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public final class KickMyself extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("onEnable has been invoked!");
	}

	@Override
	public void onDisable() {
		getLogger().info("onDisable has been invoked!");
	}

	// COMMANDS
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("leave")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command can only be run by a player.");
			} else {
				Player player = (Player) sender;
				if (player.hasPermission("kickmyself.leave")) {
					player.kickPlayer("You left this Server.");
				}
			}
			return true;
		}
		return false;
	}

}