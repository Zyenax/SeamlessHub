package net.hub.main.handlers;

import net.hub.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupHandler implements Listener {
	@SuppressWarnings("unused")
	private static Main plugin;

	public PickupHandler(Main hub) {
		PickupHandler.plugin = hub;
	}

	@EventHandler
	public void onPlayerPickupItem(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

}
