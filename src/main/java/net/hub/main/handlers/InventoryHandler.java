package net.hub.main.handlers;

import net.hub.main.Main;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class InventoryHandler implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public InventoryHandler(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onClickEvent(InventoryClickEvent e) {
		if (e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) {
			if(e.getWhoClicked().getInventory().equals(InventoryType.CREATIVE)){
				e.setCancelled(false);
			}
		} else
			e.setCancelled(true);
	}

}
