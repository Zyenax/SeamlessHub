package net.hub.main.handlers;

import net.hub.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class BlockSpread implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public BlockSpread(Main listener) {
		this.plugin = listener;		
	}
	
	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
	event.setCancelled(true);
	}
	
}
