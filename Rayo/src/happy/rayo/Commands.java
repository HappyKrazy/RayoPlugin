package happy.rayo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{
	
	private Main plugin;
	
	public Commands(Main plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
			
				if(!(sender instanceof Player)) {
					Bukkit.getConsoleSender().sendMessage(plugin.name+" Unable to send commands from the console");
					return false;
				}
				else {
					Player player = (Player) sender;
					if (args.length > 0) {
						if(args[0].equals("rayo")) {
							Location location = player.getLocation();
							LightningStrike impact = location.getWorld().strikeLightning(location);		
							return true;
						}
						else if(args[0].equals("version")) {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&8current version of the plugin is &b"+plugin.version));
							return true;
						}
						else {
							player.sendMessage(ChatColor.translateAlternateColorCodes('&',plugin.name+" &cThe command does not exist."));
							return true;
						}
						
					}
					else {
						player.sendMessage("");
						player.sendMessage(ChatColor.translateAlternateColorCodes(
								'&',"&a----------&e&lRayo&a----------"+
									"\n/rayo rayo: Throw lightning at yourself"+
									"\n/rayo version: See the plugin version"+
									"\n&a------------------------------"
								));
						player.sendMessage("");
					}
				}		
			return false;
		}
}
