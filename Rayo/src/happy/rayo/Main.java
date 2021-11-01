package happy.rayo;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	
	public PluginDescriptionFile info = getDescription();
	public String name = ChatColor.translateAlternateColorCodes('&',"&e&l["+info.getName()+"]&f");
	public String version = info.getVersion();
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',name+" &fhas been enable"));
		registerCommands();
	}

	public void registerCommands() {
		this.getCommand("rayo").setExecutor(new Commands(this));
	}
}
