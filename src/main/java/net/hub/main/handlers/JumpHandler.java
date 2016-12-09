package net.hub.main.handlers;

import net.hub.main.Main;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class JumpHandler
  implements Listener
{
  @SuppressWarnings("unused")
private Main plugin;
  
  public JumpHandler(Main listener)
  {
    this.plugin = listener;
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    p.setAllowFlight(true);
    p.setFlying(false);
  }
  
  @SuppressWarnings("deprecation")
@EventHandler
  public void onPlayerFly(PlayerToggleFlightEvent e)
  {
    Player p = e.getPlayer();
    if (p.getGameMode() != GameMode.CREATIVE)
    {
      e.setCancelled(true);
      p.setAllowFlight(false);
      p.setFlying(false);
      p.setVelocity(p.getLocation().getDirection().multiply(2.0D)
        .setY(1.0D));
      p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 15);
      p.playEffect(p.getLocation(), Effect.COLOURED_DUST, 15);
      p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 15);
      p.playEffect(p.getLocation(), Effect.COLOURED_DUST, 15);
    }
  }
  
  @EventHandler
  public void move(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if ((e.getPlayer().getGameMode() != GameMode.CREATIVE) && 
      (p.getLocation().getBlock().getRelative(BlockFace.DOWN)
      .getType() != Material.AIR)) {
      p.setAllowFlight(true);
    }
  }
}
