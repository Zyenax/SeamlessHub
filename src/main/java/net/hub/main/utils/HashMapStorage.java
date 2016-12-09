package net.hub.main.utils;

import java.util.HashMap;

import net.hub.main.Main;

import org.bukkit.event.Listener;

public class HashMapStorage implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	public HashMapStorage(Main listener) {
		this.plugin = listener;		
	}
	
	public static HashMap<String, Integer> PlayerCount = new HashMap<String, Integer>();
}
