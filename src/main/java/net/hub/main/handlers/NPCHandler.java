package net.hub.main.handlers;

import net.hub.main.Main;
import net.hub.main.utils.BungeeUtil;
import net.hub.main.utils.HoloGrams;
import net.hub.main.utils.NPCUtil;
import net.hub.main.utils.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class NPCHandler implements Listener{
	
	private static Main plugin;
	public NPCHandler(Main listener) {
		NPCHandler.plugin = listener;	
	}
	
	public static Player player;
	public static Location loc1 = new Location(Bukkit.getWorld("world"), 769.5, 30.0, 439.5, 90, 0);
	public static Location loc2 = new Location(Bukkit.getWorld("world"), 769.5, 30.0, 443.5, 90, 0);
	public static void loadNpcs(){
		Zombie npc1 = (Zombie) loc1.getWorld().spawn(loc1, Zombie.class);
		NPCUtil.createStandingNPC(npc1, false);
		npc1.setCustomNameVisible(false);
		npc1.setBaby(false);
		npc1.getEquipment().setHelmet(Utils.createSkull("Jarofdirt", null, null));
		npc1.getEquipment().setChestplate(Utils.createItem(Material.IRON_CHESTPLATE, 1, 0, null, null));
		npc1.getEquipment().setLeggings(Utils.createItem(Material.IRON_LEGGINGS, 1, 0, null, null));
		npc1.getEquipment().setBoots(Utils.createItem(Material.IRON_BOOTS, 1, 0, null, null));
		npc1.getEquipment().setItemInHand(Utils.createItem(Material.IRON_SWORD, 1, 0, null, null));
		HoloGrams.createHoloGram(loc1.add(0, 0.3, 0), Utils.color("&6KitPvP"), 1, false, false, null, null, null);
		HoloGrams.createHoloGram(loc1.add(0, -0.3, 0), Utils.color("&eNULL Playing"), 2, false, false, null, null, null);
		
		Zombie npc2 = (Zombie) loc2.getWorld().spawn(loc2, Zombie.class);
		NPCUtil.createStandingNPC(npc2, false);
		npc2.setCustomNameVisible(false);
		npc2.setBaby(false);
		npc2.getEquipment().setHelmet(Utils.createSkull("Jarofdirt", null, null));
		npc2.getEquipment().setChestplate(Utils.createItem(Material.IRON_CHESTPLATE, 1, 0, null, null));
		npc2.getEquipment().setLeggings(Utils.createItem(Material.IRON_LEGGINGS, 1, 0, null, null));
		npc2.getEquipment().setBoots(Utils.createItem(Material.IRON_BOOTS, 1, 0, null, null));
		npc2.getEquipment().setItemInHand(Utils.createItem(Material.IRON_SWORD, 1, 0, null, null));
		HoloGrams.createHoloGram(loc2.add(0, 0.3, 0), Utils.color("&6Ranked KitPvP"), 3, false, false, null, null, null);
		HoloGrams.createHoloGram(loc2.add(0, -0.3, 0), Utils.color("&eNULL Playing"), 4, false, false, null, null, null);
	}
	
	public static void NPCNameUpdater(){
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
    		public void run() {
    			for(Player player : Bukkit.getOnlinePlayers()){
    				HoloGrams.renameHoloGram("&e" + BungeeUtil.playerCountOfServer(player, "KitPvP") + " Playing", 2);
    				HoloGrams.renameHoloGram("&e" + BungeeUtil.playerCountOfServer(player, "RankedKPVP") + " Playing", 4);
    			}
    		}
    	}, 0, 5);
	}
	
	@EventHandler
	public void npcInteract(PlayerInteractEntityEvent event){
		if (event.getRightClicked().getType() == EntityType.ZOMBIE && event.getRightClicked().getLocation().equals(loc1)) {
			event.setCancelled(true);
			BungeeUtil.sendToServer(event.getPlayer(), "KitPvP");
		}else if (event.getRightClicked().getType() == EntityType.ZOMBIE && event.getRightClicked().getLocation().equals(loc2)) {
			event.setCancelled(true);
			BungeeUtil.sendToServer(event.getPlayer(), "RankedKPVP");
		}
	}
	
	@EventHandler
	public void npcCombust(EntityCombustEvent event){
		if(event.getEntityType() != EntityType.PLAYER){
			event.setCancelled(true);
		}
	}

}
