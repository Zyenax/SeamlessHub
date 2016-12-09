package net.hub.main;

import java.util.Arrays;

import net.hub.main.handlers.ScoreBoardHandler;
import net.hub.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public PlayerJoin(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Player player = event.getPlayer();
		event.setJoinMessage(Utils.color("&8[&a+&8] &e" + player.getName()));
		player.getInventory().clear();
		event.getPlayer().setFoodLevel(20);
		giveItems(player);
		Location loc = new Location(Bukkit.getWorld("world"), 763.5, 32, 441.5, -90, 0);
		player.teleport(loc);
		player.setScoreboard(ScoreBoardHandler.board);
		player.setGameMode(GameMode.ADVENTURE);
	}
	
	public static void giveItems(Player p){
		ItemStack selector = Utils.createItem(Material.COMPASS,1,0,Utils.color("&eServer Selector &7- &bRight Click"), Arrays.asList(Utils.color("&aRight click to open the Server Menu!")));

		p.getInventory().setItem(0, selector);
	}

}
