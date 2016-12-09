package net.hub.main;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;

import net.hub.main.handlers.BlockSpread;
import net.hub.main.handlers.BuildHandler;
import net.hub.main.handlers.CommandHandler;
import net.hub.main.handlers.DamageHandler;
import net.hub.main.handlers.DropHandler;
import net.hub.main.handlers.HungerHandler;
import net.hub.main.handlers.InventoryHandler;
import net.hub.main.handlers.ItemHandler;
import net.hub.main.handlers.JumpHandler;
import net.hub.main.handlers.NPCHandler;
import net.hub.main.handlers.PadHandler;
import net.hub.main.handlers.PickupHandler;
import net.hub.main.handlers.ScoreBoardHandler;
import net.hub.main.handlers.WeatherHandler;
import net.hub.main.menus.GameMenu;
import net.hub.main.utils.BungeeUtil;
import net.hub.main.utils.HashMapStorage;
import net.hub.main.utils.HoloGrams;
import net.hub.main.utils.NPCUtil;
import net.hub.main.utils.Packets;
import net.hub.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class Main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public static String GetServer;
	public static String[] serverList;
	
	public void onEnable(){
		registerListeners();
		registerCommands();
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&a&lThe hub plugin has been enabled!"));
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	    List<Entity> entities = Bukkit.getWorld("world").getEntities();
		for ( Entity entity : entities){
			if((entity.getType() != EntityType.PLAYER)){
				entity.remove();
			}
		}
		for(Player p : Bukkit.getOnlinePlayers()){
			p.setGameMode(GameMode.ADVENTURE);
		}
		NPCHandler.loadNpcs();
		NPCHandler.NPCNameUpdater();
	}
	
	public void onDisable(){
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(Utils.color("&a&lThe hub plugin has been disabled!"));
		 List<Entity> entities = Bukkit.getWorld("world").getEntities();
			for ( Entity entity : entities){
				if((entity.getType() != EntityType.PLAYER)){
					entity.remove();
				}
			}
	}
	
	public void registerListeners(){
		PluginManager manager = Bukkit.getServer().getPluginManager();
		manager.registerEvents(new PlayerJoin(this), this);
		manager.registerEvents(new PlayerQuit(this), this);
		manager.registerEvents(new BuildHandler(this), this);
		manager.registerEvents(new DropHandler(this), this);
		manager.registerEvents(new HungerHandler(this), this);
		manager.registerEvents(new PickupHandler(this), this);
		manager.registerEvents(new ScoreBoardHandler(this), this);
		manager.registerEvents(new WeatherHandler(this), this);
		manager.registerEvents(new BungeeUtil(this), this);
		manager.registerEvents(new HashMapStorage(this), this);
		manager.registerEvents(new HoloGrams(this), this);
		manager.registerEvents(new NPCUtil(this), this);
		manager.registerEvents(new Packets(this), this);
		manager.registerEvents(new Utils(this), this);
		manager.registerEvents(new DamageHandler(this), this);
		manager.registerEvents(new BlockSpread(this), this);
		manager.registerEvents(new ItemHandler(this), this);
		manager.registerEvents(new GameMenu(this), this);
		manager.registerEvents(new InventoryHandler(this), this);
		manager.registerEvents(new PadHandler(this), this);
		manager.registerEvents(new JumpHandler(this), this);
		manager.registerEvents(new CommandHandler(this), this);
		manager.registerEvents(new NPCHandler(this), this);
	}
	
	public void registerCommands(){
		getCommand("spawn").setExecutor(new CommandHandler(this));
	}
	
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    try{
	    	DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
		    String subchannel = in.readUTF();
	    if (subchannel.equals("PlayerCount")) {
	    	String PlayerCountServer = in.readUTF();
	    	Integer playercount = in.readInt();
	    	HashMapStorage.PlayerCount.remove(PlayerCountServer);
	    	HashMapStorage.PlayerCount.put(PlayerCountServer, playercount);
        } else if (subchannel.equals("GetServers")) {
        	serverList = in.readUTF().split("\n");
        } else if (subchannel.equals("GetServer")) {
            // Example: GetServer subchannel
        	GetServer = in.readUTF();
        }
	    }catch (Exception e){
	    	e.printStackTrace();
	    }
	  }

}
