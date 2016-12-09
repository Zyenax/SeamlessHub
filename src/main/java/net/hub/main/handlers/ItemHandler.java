package net.hub.main.handlers;

import net.hub.main.Main;
import net.hub.main.menus.GameMenu;
import net.hub.main.utils.Utils;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemHandler implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;

	public ItemHandler(Main hub) {
		this.plugin = hub;
	}

	@EventHandler
	public void gamemenu(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand() != null) {
				if (e.getPlayer().getItemInHand().getType() == Material.COMPASS) {
					if(e.getPlayer().getItemInHand().hasItemMeta()){
						if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(Utils.color("&eServer Selector &7- &bRight Click"))){
							GameMenu.Menu(e.getPlayer());
						}
					}
				}
			}
		}
	}
}