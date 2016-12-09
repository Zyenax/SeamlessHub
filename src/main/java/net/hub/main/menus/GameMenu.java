package net.hub.main.menus;

import java.util.Arrays;
import java.util.HashMap;

import net.hub.main.Main;
import net.hub.main.utils.BungeeUtil;
import net.hub.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class GameMenu implements Listener{
	
	public static Inventory inv;
	
	private static Main plugin;
	public GameMenu(Main listener) {
		GameMenu.plugin = listener;	
		Inventory inventory = Bukkit.createInventory(null, 45, Utils.color("&8Servers"));
		inv = inventory;
		Border();
		KitPvP("KitPvP");
		RankedKitPvP("RankedKPVP");
	}
	
	static HashMap<Player, BukkitTask> MenuMap = new HashMap<Player, BukkitTask>();
	public static void Menu(final Player p){
		p.openInventory(inv);
		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		if(!(MenuMap.containsKey(p))){
			MenuMap.put(p, scheduler.runTaskTimer(plugin, new Runnable() {
				public void run() {
					Border();
					p.updateInventory();
				}	
			}, 0, 10L));
		}else{
			MenuMap.get(p).cancel();
			MenuMap.remove(p);
			return;
		}
	}
	
	@EventHandler
	public void onInvClose(InventoryCloseEvent event){
		if(MenuMap.containsKey(event.getPlayer())){
			MenuMap.get(event.getPlayer()).cancel();
			MenuMap.remove(event.getPlayer());
		}
	}
	
	public static void Border(){
		ItemStack border = Utils.createItem(Material.STAINED_GLASS_PANE, 1, 15, Utils.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void KitPvP(final String servername){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item = Utils.createItem(Material.CHEST, 1, 0, Utils.color("&eKitPvP"), Arrays.asList(Utils.color(" "), Utils.color("&7Fight against other players"), Utils.color("&7in order to level up and gain"), Utils.color("&7some currency to compete with your friends"), Utils.color("&7and possibly a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername) + " &8others"), Utils.color("&0♦ &bClick to join this server")));
            			inv.setItem(20, item);
    				}
    			}
    		}
		}, 10);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item = Utils.createItem(Material.CHEST, 1, 0, Utils.color("&eKitPvP"), Arrays.asList(Utils.color(" "), Utils.color("&7Fight against other players"), Utils.color("&7in order to level up and gain"), Utils.color("&7some currency to compete with your friends"), Utils.color("&7and possibly a chance to win epic gear!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername) + " &8others"), Utils.color("&b♦ &bClick to join this server")));
            			inv.setItem(20, item);
    				}
    			}
    		}
		}, 20);
    		}
		}, 0, 20);
	}
	
	public static void RankedKitPvP(final String servername){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item = Utils.createItem(Material.CHEST, 1, 0, Utils.color("&eRanked KitPvP"), Arrays.asList(Utils.color(" "), Utils.color("&7Fight against other players"), Utils.color("&7in order to gain elo and try to"), Utils.color("&7climb the ladder to be the #1"), Utils.color("&7pvp'er on the server!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername) + " &8others"), Utils.color("&0♦ &bClick to join this server")));
            			inv.setItem(24, item);
    				}
    			}
    		}
		}, 10);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				if(player != null){
    					ItemStack item = Utils.createItem(Material.CHEST, 1, 0, Utils.color("&eRanked KitPvP"), Arrays.asList(Utils.color(" "), Utils.color("&7Fight against other players"), Utils.color("&7in order to gain elo and try to"), Utils.color("&7climb the ladder to be the #1"), Utils.color("&7pvp'er on the server!"), Utils.color(" "), Utils.color("&8Join &a" + BungeeUtil.playerCountOfServer(player, servername) + " &8others"), Utils.color("&b♦ &bClick to join this server")));
            			inv.setItem(24, item);
    				}
    			}
    		}
		}, 20);
    		}
		}, 0, 20);
	}
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
		if(e.getInventory().getName().equals(Utils.color("&8Servers"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(e.getInventory() != null){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							
							if(e.getCurrentItem().getType().equals(Material.CHEST)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&eKitPvP"))){
									e.setCancelled(true);
									BungeeUtil.sendToServer(p, "KitPvP");
									p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							if(e.getCurrentItem().getType().equals(Material.CHEST)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color("&eRanked KitPvP"))){
									e.setCancelled(true);
									BungeeUtil.sendToServer(p, "RankedKPVP");
									p.playSound(p.getLocation(), Sound.ENDERDRAGON_WINGS, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							//BORDER
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Utils.color(" "))){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							
						}
					}
				}
			}
		}
	}

}
